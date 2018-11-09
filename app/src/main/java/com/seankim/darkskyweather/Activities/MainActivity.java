package com.seankim.darkskyweather.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.seankim.darkskyweather.Models.CurrentlyWeatherModel;
import com.seankim.darkskyweather.Models.WeatherDataModel;
import com.seankim.darkskyweather.Models.WeatherModel;
import com.seankim.darkskyweather.Net.WeatherNet;
import com.seankim.darkskyweather.R;
import com.seankim.darkskyweather.Utils.SeparatorDeco;
import com.seankim.darkskyweather.Utils.WeatherIcons;
import com.seankim.darkskyweather.Utils.TimeUtils;

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

    final private double mLatitude = 32.715736;
    final private double mLongitude = -117.161087;
    private LayoutInflater mInflater;
    private List<WeatherDataModel> mDailyWeatherDataModel = new ArrayList<>();
    private DailyReportAdapter mDailyReportAdapter = new DailyReportAdapter();
    private Animation mUpdateAnim;

    @BindView(R.id.icTodayWeather)
    ImageView mIconTodayWeather;
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

        mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.INTERNET }, 0);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setAdapter(mDailyReportAdapter);
        mRecyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setLayoutManager(layoutManager);
        SeparatorDeco decoration = new SeparatorDeco(this, Color.GRAY, 1.0f);
        mRecyclerView.addItemDecoration(decoration);

        mBtnRefresh.setOnClickListener(mRefreshBtnClickListener);
        mUpdateAnim = AnimationUtils.loadAnimation(this, R.anim.anim_refresh_rotate);
        mBtnRefresh.startAnimation(mUpdateAnim);

        getWeather();
    }

    private View.OnClickListener mRefreshBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getWeather();
        }
    };

    @NeedsPermission(Manifest.permission.INTERNET)
    public void getWeather() {
        mBtnRefresh.startAnimation(mUpdateAnim);

        WeatherNet.getWeather(mLatitude, mLongitude).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Response<WeatherModel>>() {
            @Override
            public void onNext(Response<WeatherModel> response) {
                unsubscribe();
                if (response.isSuccessful()) {
                    WeatherModel weather = response.body();
                    if (weather != null) {
                        CurrentlyWeatherModel currently = weather.getCurrently();

                        mTvTemperature.setText(String.format("%.1f", currently.getTemperature()) + "\u00b0F");
                        mTvSummary.setText(currently.getSummary());

                        mDailyWeatherDataModel = weather.getDaily().getData();
                        mDailyReportAdapter.notifyDataSetChanged();

                        Integer iconResource = WeatherIcons.getIconResource(currently.getIcon());
                        mIconTodayWeather.setImageResource(iconResource);
                    }
                    mBtnRefresh.clearAnimation();
                }
            }

            @Override
            public void onCompleted() {
                mBtnRefresh.clearAnimation();
            }

            @Override
            public void onError(Throwable e) {
                mBtnRefresh.clearAnimation();
            }
        });
    }

    class DailyReportAdapter extends RecyclerView.Adapter<DailyReportViewHolder> {
        @Override
        public DailyReportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.item_daily_weather, parent, false);
            return new DailyReportViewHolder(view);
        }

        @Override
        public void onBindViewHolder(DailyReportViewHolder holder, final int position) {
            WeatherDataModel dailyData = mDailyWeatherDataModel.get(position);

            String day = TimeUtils.getDayOfWeek(dailyData.getTime());
            holder.setWeekday(day);
            String date = TimeUtils.getDate(dailyData.getTime());
            holder.setDate(date);
            holder.setIcon(dailyData.getIcon());
            Double tempHigh = dailyData.getTemperatureHigh();
            holder.setTempHigh(String.format("%.1f", tempHigh));
            Double tempLow = dailyData.getTemperatureLow();
            holder.setTempLow(String.format("%.1f", tempLow));
            holder.setSummary(dailyData.getSummary());

            // add click listener
            holder.holder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), DailyWeatherDetailActivity.class);
                    Gson gson = new Gson();
                    String jsonData = gson.toJson(mDailyWeatherDataModel.get(position));
                    intent.putExtra("detailData", jsonData);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mDailyWeatherDataModel.size();
        }


    }

    class DailyReportViewHolder extends RecyclerView.ViewHolder {
        View holder;
        ImageView icon;
        TextView date, weekday, tempHigh, tempLow, summary;
        //TouchListener touchListener = new TouchListener();

        DailyReportViewHolder(View view) {
            super(view);
            holder = view.findViewById(R.id.item_daily_info_holder);

            date = view.findViewById(R.id.tv_daily_info_date);
            weekday = view.findViewById(R.id.tv_daily_info_weekday);
            icon = view.findViewById(R.id.ic_daily_info_icon);
            tempHigh = view.findViewById(R.id.tv_daily_info_temp_high);
            tempLow = view.findViewById(R.id.tv_daily_info_temp_low);
            summary = view.findViewById(R.id.tv_daily_info_summary);
        }

        public void setDate(String date) {
            this.date.setText(date);
        }
        public void setWeekday(String weekday) {
            this.weekday.setText(weekday);
        }
        public void setIcon(String resource) {
            Integer imageRsc = WeatherIcons.getIconResource(resource);
            this.icon.setImageResource(Integer.valueOf(imageRsc));
        }
        public void setTempHigh(String temp) {
            this.tempHigh.setText(temp + "\u00b0F");
        }
        public void setTempLow(String temp) {
            this.tempLow.setText(temp + "\u00b0F");
        }
        public void setSummary(String summary) {
            this.summary.setText(summary);
        }
    }
}
