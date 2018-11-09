package com.seankim.darkskyweather.Net;


import com.seankim.darkskyweather.Models.WeatherModel;

import rx.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeatherService {
    @GET("{lat},{lon}")
    Observable<Response<WeatherModel>> getWeather(
            @Path("lat") double lat,
            @Path("lon") double lon
    );
}