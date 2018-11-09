package com.seankim.darkskyweather.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DailyWeatherModel {

    @SerializedName("summary")
    @Expose
    private String mSummary;
    @SerializedName("icon")
    @Expose
    private String mIcon;
    @SerializedName("data")
    @Expose
    private List<WeatherDataModel> mDataList = null;

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

    public List<WeatherDataModel> getData() {
        return mDataList;
    }

    public void setData(List<WeatherDataModel> data) {
        this.mDataList = data;
    }

}
