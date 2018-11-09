package com.seankim.darkskyweather.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherModel {

    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    //    @SerializedName("timezone")
//    @Expose
//    private String timezone;
    @SerializedName("currently")
    @Expose
    private CurrentlyWeatherModel currently;
    @SerializedName("daily")
    @Expose
    private DailyWeatherModel daily;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    //    public String getTimezone() {
//        return timezone;
//    }
//
//    public void setTimezone(String timezone) {
//        this.timezone = timezone;
//    }
//
    public CurrentlyWeatherModel getCurrently() {
        return currently;
    }

    public void setCurrently(CurrentlyWeatherModel currently) {
        this.currently = currently;
    }

    public DailyWeatherModel getDaily() {
        return daily;
    }

    public void setDaily(DailyWeatherModel daily) {
        this.daily = daily;
    }
}

