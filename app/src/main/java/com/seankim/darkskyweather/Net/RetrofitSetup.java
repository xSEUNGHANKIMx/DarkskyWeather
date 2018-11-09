package com.seankim.darkskyweather.Net;

import java.io.File;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSetup {

    private static final String URL = "https://api.darksky.net/forecast";
    private static final String SECRET_KEY = "9ddb5bc933606669297dc963fbd3574b";
    private static Retrofit retrofit = null;

    public static Retrofit retrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL + File.separator + SECRET_KEY + File.separator)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

