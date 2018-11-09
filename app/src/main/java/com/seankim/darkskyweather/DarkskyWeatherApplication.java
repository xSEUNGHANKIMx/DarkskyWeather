package com.seankim.darkskyweather;

import android.app.Application;
import android.content.Context;

public class DarkskyWeatherApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        DarkskyWeatherApplication.context = getApplicationContext();
    }

    public static Context getContext() {
        return DarkskyWeatherApplication.context;
    }
}