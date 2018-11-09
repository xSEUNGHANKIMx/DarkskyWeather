package com.seankim.darkskyweather.Utils;

import com.seankim.darkskyweather.R;

import java.util.HashMap;
import java.util.Map;

public class WeatherIcons {

    private static Map<String, Integer> icons = new HashMap<>();

    static {
        icons.put("clear-day", R.drawable.clear_day);
        icons.put("clear-night", R.drawable.clear_night);
        icons.put("rain", R.drawable.rain);
        icons.put("snow", R.drawable.snow);
        icons.put("sleet", R.drawable.sleet);
        icons.put("windy", R.drawable.windy);
        icons.put("fog", R.drawable.foggy);
        icons.put("cloudy", R.drawable.cloudy);
        icons.put("partly-cloudy-day", R.drawable.little_cloudy_day);
        icons.put("partly-cloudy-night", R.drawable.little_cloudy_night);
        icons.put("thunderstorm", R.drawable.stormy);
    }

    public static Integer getIconResource(String key) {
        return icons.get(key);    }
}