package com.seankim.darkskyweather.Utils;

import com.seankim.darkskyweather.R;

import java.util.HashMap;
import java.util.Map;

public class WeatherIcons {

    private static Map<String, Integer> mIcons = new HashMap<>();

    static {
        mIcons.put("clear-day", R.drawable.ic_clear_day);
        mIcons.put("clear-night", R.drawable.ic_clear_night);
        mIcons.put("rain", R.drawable.ic_rain);
        mIcons.put("snow", R.drawable.ic_snow);
        mIcons.put("sleet", R.drawable.ic_sleet);
        mIcons.put("windy", R.drawable.ic_windy);
        mIcons.put("fog", R.drawable.ic_foggy);
        mIcons.put("cloudy", R.drawable.ic_cloudy);
        mIcons.put("partly-cloudy-day", R.drawable.ic_little_cloudy_day);
        mIcons.put("partly-cloudy-night", R.drawable.ic_little_cloudy_night);
        mIcons.put("thunderstorm", R.drawable.ic_stormy);
    }

    public static Integer getIconResource(String key) {
        return mIcons.get(key);    }
}