package com.seankim.darkskyweather.Utils;

import com.seankim.darkskyweather.R;

import java.util.HashMap;
import java.util.Map;

public class WeatherIcons {

    private static Map<String, Integer> iconMap = new HashMap<>();

    static {
        iconMap.put("clear-day", R.drawable.clear_day);
        iconMap.put("clear-night", R.drawable.clear_night);
        iconMap.put("rain", R.drawable.rain);
        iconMap.put("snow", R.drawable.snow);
        iconMap.put("sleet", R.drawable.sleet);
        iconMap.put("windy", R.drawable.windy);
        iconMap.put("fog", R.drawable.foggy);
        iconMap.put("cloudy", R.drawable.cloudy);
        iconMap.put("partly-cloudy-day", R.drawable.little_cloudy_day);
        iconMap.put("partly-cloudy-night", R.drawable.little_cloudy_night);
        iconMap.put("thunderstorm", R.drawable.stormy);
    }

    public static Integer getIconResource(String key) {
        return iconMap.get(key);
    }

}