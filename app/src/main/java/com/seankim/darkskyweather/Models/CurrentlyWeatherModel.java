package com.seankim.darkskyweather.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentlyWeatherModel {

    @SerializedName("time")
    @Expose
    private Integer mTime;
    @SerializedName("summary")
    @Expose
    private String mSummary;
    @SerializedName("icon")
    @Expose
    private String mIcon;
    @SerializedName("temperature")
    @Expose
    private Double mTemperature;

    public Integer getTime() {
        return mTime;
    }

    public void setTime(Integer time) {
        this.mTime = time;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        this.mSummary = summary;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        this.mIcon = icon;
    }

    public Double getTemperature() {
        return mTemperature;
    }

    public void setTemperature(Double temperature) {
        this.mTemperature = temperature;
    }

}
