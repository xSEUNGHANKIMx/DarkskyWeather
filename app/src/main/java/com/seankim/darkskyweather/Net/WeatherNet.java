package com.seankim.darkskyweather.Net;

import com.seankim.darkskyweather.Models.WeatherModel;

import retrofit2.Response;
import rx.Observable;
import rx.schedulers.Schedulers;

public class WeatherNet {
    private static final WeatherService weatherService;

    static {
        weatherService = RetrofitSetup.retrofit().create(WeatherService.class);
    }

    public static Observable<Response<WeatherModel>> getWeather(double lat, double lon) {
        return weatherService.getWeather(lat, lon).subscribeOn(Schedulers.io());
    }
}
