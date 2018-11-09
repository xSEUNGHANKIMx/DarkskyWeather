package com.seankim.darkskyweather.Activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.support.v4.app.ActivityCompat;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.seankim.darkskyweather.DarkskyWeatherApplication;
import com.seankim.darkskyweather.Models.CurrentlyWeatherModel;
import com.seankim.darkskyweather.Models.WeatherDataModel;
import com.seankim.darkskyweather.Models.WeatherModel;
import com.seankim.darkskyweather.Net.WeatherNet;
import com.seankim.darkskyweather.R;
import com.seankim.darkskyweather.Utils.ProgressFlower;
import com.seankim.darkskyweather.Utils.TouchListener;
import com.seankim.darkskyweather.Utils.WeatherIcons;
import com.seankim.darkskyweather.Utils.WeatherTime;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import permissions.dispatcher.RuntimePermissions;
import permissions.dispatcher.NeedsPermission;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    final private double mLatitude = 32.715736;
    final private double mLongitude = -117.161087;
    private LayoutInflater mInflater;
    private Context mContext;
    private ProgressFlower mProgress;
    private List<WeatherDataModel> mDailyWeatherDataModel = new ArrayList<>();
    private DailyReportAdapter mDailyReportAdapter = new DailyReportAdapter();
    private Animation mUpdateAnim;

    @BindView(R.id.icTodaysWeather)
    ImageView mIconTodaysWeather;
    @BindView(R.id.tvTemperature)
    TextView mTvTemperature;
    @BindView(R.id.tvSummary)
    TextView mTvSummary;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh_button)
    ImageView mBtnRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mContext = this;
        mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.INTERNET }, 0);
        }

        mRecyclerView.setAdapter(mDailyReportAdapter);
        mRecyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        mBtnRefresh.setOnClickListener(mRefreshBtnClickListener);
        mUpdateAnim = AnimationUtils.loadAnimation(this, R.anim.refresh_rotate_anim);
        mBtnRefresh.startAnimation(mUpdateAnim);

        getWeather();
    }

    private View.OnClickListener mRefreshBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mBtnRefresh.startAnimation(mUpdateAnim);
            MainActivityPermissionsDispatcher.getWeatherWithPermissionCheck(MainActivity.this);
        }
    };

    @SuppressLint("NeedOnRequestPermissionsResult")
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            }
        }
    }

    @NeedsPermission(Manifest.permission.INTERNET)
    public void getWeather() {
        mProgress = new ProgressFlower.Builder(this).direction(ProgressFlower.DIRECT_CLOCKWISE).themeColor(Color.WHITE).build();
        mProgress.show();

        WeatherNet.getWeather(mLatitude, mLongitude).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Response<WeatherModel>>() {
            @Override
            public void onNext(Response<WeatherModel> response) {
                unsubscribe();
                if (response.isSuccessful()) {
                    WeatherModel weather = response.body();
                    if (weather != null) {
                        CurrentlyWeatherModel currently = weather.getCurrently();
                        Log.e(TAG, "Temperature = " + currently.getTemperature());

                        mTvTemperature.setText(String.valueOf(currently.getTemperature()) + "\u00b0F");
                        mTvSummary.setText(currently.getSummary());

                        mDailyWeatherDataModel = weather.getDaily().getData();
                        mDailyReportAdapter.notifyDataSetChanged();

                        Integer iconResource = WeatherIcons.getIconResource(currently.getIcon());
                        mIconTodaysWeather.setImageResource(iconResource);
                    } else {
                        Log.e(TAG, "No response, check your key");
                    }
                    mProgress.dismiss();
                    mBtnRefresh.clearAnimation();
                }
            }

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onFailure, unable to get weather data");
                mProgress.dismiss();
            }
        });
    }

    private class DailyReportAdapter extends RecyclerView.Adapter<DailyReportViewHolder> {
        @Override
        public DailyReportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.item_daily_weather, parent, false);
            return new DailyReportViewHolder(view);
        }

        @Override
        public void onBindViewHolder(DailyReportViewHolder holder, int position) {
            WeatherDataModel dailyData = mDailyWeatherDataModel.get(position);
            holder.setIcon(dailyData.getIcon());
            holder.setSummary(dailyData.getSummary());
            Double tempHigh = dailyData.getTemperatureHigh();
            holder.setTempHigh(String.valueOf(tempHigh));
            Double tempLow = dailyData.getTemperatureLow();
            holder.setTempLow(String.valueOf(tempLow));
            String day = WeatherTime.getDayOfWeek(dailyData.getTime());
            holder.setWeekday(day);
            String date = WeatherTime.getDate(dailyData.getTime());
            holder.setDate(date);
            Log.e("=====", day + " :" + dailyData.getTime());
        }

        @Override
        public int getItemCount() {
            return mDailyWeatherDataModel.size();
        }
    }


    public class DailyReportViewHolder extends RecyclerView.ViewHolder {
        View root;
        ImageView icon;
        TextView summary, tempHigh, tempLow, weekday, date;
        TouchListener touchListener = new TouchListener();

        DailyReportViewHolder(View view) {
            super(view);
            root = view.findViewById(R.id.cell_daily_report_root);
            icon = view.findViewById(R.id.cell_daily_report_icon);
            summary = view.findViewById(R.id.cell_daily_report_summary);
            tempHigh = view.findViewById(R.id.cell_daily_report_temp_high);
            tempLow = view.findViewById(R.id.cell_daily_report_temp_low);
            weekday = view.findViewById(R.id.cell_daily_report_weekday);
            date = view.findViewById(R.id.cell_daily_report_date);

            root.getLayoutParams().height = screenSize().y * 280 / 667;
            root.getLayoutParams().width = screenSize().x * 120 / 375;

            root.setOnTouchListener(touchListener);
//            icon.setOnTouchListener(touchListener);
        }

        public void setIcon(String resource) {
            Integer imageResource = WeatherIcons.getIconResource(resource);
            this.icon.setImageResource(Integer.valueOf(imageResource));
        }

        public void setSummary(String summary) {
            this.summary.setText(summary);
        }

        public void setTempHigh(String temp) {
            this.tempHigh.setText(temp + "\u00b0C");
        }

        public void setTempLow(String temp) {
            this.tempLow.setText(temp + "\u00b0C");
        }

        public void setWeekday(String weekday) {
            this.weekday.setText(weekday);
        }

        public void setDate(String date) {
            this.date.setText(date);
        }
    }

    Point screenSize() {
        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point screenSize = new Point();
        display.getSize(screenSize);
        return screenSize;
    }
}
