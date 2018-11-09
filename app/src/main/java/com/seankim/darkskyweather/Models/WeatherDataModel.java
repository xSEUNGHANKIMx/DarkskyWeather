package com.seankim.darkskyweather.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherDataModel {

    @SerializedName("time")
    @Expose
    private Integer mTime;
    @SerializedName("summary")
    @Expose
    private String mSummary;
    @SerializedName("icon")
    @Expose
    private String mIcon;
    @SerializedName("sunriseTime")
    @Expose
    private Integer mSunriseTime;
    @SerializedName("sunsetTime")
    @Expose
    private Integer mSunsetTime;
    @SerializedName("moonPhase")
    @Expose
    private Double mMoonPhase;
    @SerializedName("precipIntensity")
    @Expose
    private Double mPrecipIntensity;
    @SerializedName("precipIntensityMax")
    @Expose
    private Double mPrecipIntensityMax;
    @SerializedName("precipIntensityMaxTime")
    @Expose
    private Integer mPrecipIntensityMaxTime;
    @SerializedName("precipProbability")
    @Expose
    private Double mPrecipProbability;
    @SerializedName("precipType")
    @Expose
    private String mPrecipType;
    @SerializedName("temperatureHigh")
    @Expose
    private Double mTemperatureHigh;
    @SerializedName("temperatureHighTime")
    @Expose
    private Integer mTemperatureHighTime;
    @SerializedName("temperatureLow")
    @Expose
    private Double mTemperatureLow;
    @SerializedName("temperatureLowTime")
    @Expose
    private Integer mTemperatureLowTime;
    @SerializedName("apparentTemperatureHigh")
    @Expose
    private Double mApparentTemperatureHigh;
    @SerializedName("apparentTemperatureHighTime")
    @Expose
    private Integer mApparentTemperatureHighTime;
    @SerializedName("apparentTemperatureLow")
    @Expose
    private Double mApparentTemperatureLow;
    @SerializedName("apparentTemperatureLowTime")
    @Expose
    private Integer mApparentTemperatureLowTime;
    @SerializedName("dewPoint")
    @Expose
    private Double mDewPoint;
    @SerializedName("humidity")
    @Expose
    private Double mHumidity;
    @SerializedName("pressure")
    @Expose
    private Double mPressure;
    @SerializedName("windSpeed")
    @Expose
    private Double mWindSpeed;
    @SerializedName("windGust")
    @Expose
    private Double mWindGust;
    @SerializedName("windGustTime")
    @Expose
    private Integer mWindGustTime;
    @SerializedName("windBearing")
    @Expose
    private Integer mWindBearingm;
    @SerializedName("cloudCover")
    @Expose
    private Double mCloudCover;
    @SerializedName("uvIndex")
    @Expose
    private Integer mUvIndex;
    @SerializedName("uvIndexTime")
    @Expose
    private Integer mUvIndexTime;
    @SerializedName("visibility")
    @Expose
    private Double mVisibility;
    @SerializedName("ozone")
    @Expose
    private Double mOzone;
    @SerializedName("temperatureMin")
    @Expose
    private Double mTemperatureMin;
    @SerializedName("temperatureMinTime")
    @Expose
    private Integer mTemperatureMinTime;
    @SerializedName("temperatureMax")
    @Expose
    private Double mTemperatureMax;
    @SerializedName("temperatureMaxTime")
    @Expose
    private Integer mTemperatureMaxTime;
    @SerializedName("apparentTemperatureMin")
    @Expose
    private Double mApparentTemperatureMin;
    @SerializedName("apparentTemperatureMinTime")
    @Expose
    private Integer mApparentTemperatureMinTime;
    @SerializedName("apparentTemperatureMax")
    @Expose
    private Double mApparentTemperatureMax;
    @SerializedName("apparentTemperatureMaxTime")
    @Expose
    private Integer mApparentTemperatureMaxTime;

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

    public Integer getSunriseTime() {
        return mSunriseTime;
    }

    public void setSunriseTime(Integer sunriseTime) {
        this.mSunriseTime = sunriseTime;
    }

    public Integer getSunsetTime() {
        return mSunsetTime;
    }

    public void setSunsetTime(Integer sunsetTime) {
        this.mSunsetTime = sunsetTime;
    }

    public Double getMoonPhase() {
        return mMoonPhase;
    }

    public void setMoonPhase(Double moonPhase) {
        this.mMoonPhase = moonPhase;
    }

    public Double getPrecipIntensity() {
        return mPrecipIntensity;
    }

    public void setPrecipIntensity(Double precipIntensity) {
        this.mPrecipIntensity = precipIntensity;
    }

    public Double getPrecipIntensityMax() {
        return mPrecipIntensityMax;
    }

    public void setPrecipIntensityMax(Double precipIntensityMax) {
        this.mPrecipIntensityMax = precipIntensityMax;
    }

    public Integer getPrecipIntensityMaxTime() {
        return mPrecipIntensityMaxTime;
    }

    public void setPrecipIntensityMaxTime(Integer precipIntensityMaxTime) {
        this.mPrecipIntensityMaxTime = precipIntensityMaxTime;
    }

    public Double getPrecipProbability() {
        return mPrecipProbability;
    }

    public void setPrecipProbability(Double precipProbability) {
        this.mPrecipProbability = precipProbability;
    }

    public String getPrecipType() {
        return mPrecipType;
    }

    public void setPrecipType(String precipType) {
        this.mPrecipType = precipType;
    }

    public Double getTemperatureHigh() {
        return mTemperatureHigh;
    }

    public void setTemperatureHigh(Double temperatureHigh) {
        this.mTemperatureHigh = temperatureHigh;
    }

    public Integer getTemperatureHighTime() {
        return mTemperatureHighTime;
    }

    public void setTemperatureHighTime(Integer temperatureHighTime) {
        this.mTemperatureHighTime = temperatureHighTime;
    }

    public Double getTemperatureLow() {
        return mTemperatureLow;
    }

    public void setTemperatureLow(Double temperatureLow) {
        this.mTemperatureLow = temperatureLow;
    }

    public Integer getTemperatureLowTime() {
        return mTemperatureLowTime;
    }

    public void setTemperatureLowTime(Integer temperatureLowTime) {
        this.mTemperatureLowTime = temperatureLowTime;
    }

    public Double getApparentTemperatureHigh() {
        return mApparentTemperatureHigh;
    }

    public void setApparentTemperatureHigh(Double apparentTemperatureHigh) {
        this.mApparentTemperatureHigh = apparentTemperatureHigh;
    }

    public Integer getApparentTemperatureHighTime() {
        return mApparentTemperatureHighTime;
    }

    public void setApparentTemperatureHighTime(Integer apparentTemperatureHighTime) {
        this.mApparentTemperatureHighTime = apparentTemperatureHighTime;
    }

    public Double getApparentTemperatureLow() {
        return mApparentTemperatureLow;
    }

    public void setApparentTemperatureLow(Double apparentTemperatureLow) {
        this.mApparentTemperatureLow = apparentTemperatureLow;
    }

    public Integer getApparentTemperatureLowTime() {
        return mApparentTemperatureLowTime;
    }

    public void setApparentTemperatureLowTime(Integer apparentTemperatureLowTime) {
        this.mApparentTemperatureLowTime = apparentTemperatureLowTime;
    }

    public Double getDewPoint() {
        return mDewPoint;
    }

    public void setDewPoint(Double dewPoint) {
        this.mDewPoint = dewPoint;
    }

    public Double getHumidity() {
        return mHumidity;
    }

    public void setHumidity(Double humidity) {
        this.mHumidity = humidity;
    }

    public Double getPressure() {
        return mPressure;
    }

    public void setPressure(Double pressure) {
        this.mPressure = pressure;
    }

    public Double getWindSpeed() {
        return mWindSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.mWindSpeed = windSpeed;
    }

    public Double getWindGust() {
        return mWindGust;
    }

    public void setWindGust(Double windGust) {
        this.mWindGust = windGust;
    }

    public Integer getWindGustTime() {
        return mWindGustTime;
    }

    public void setWindGustTime(Integer windGustTime) {
        this.mWindGustTime = windGustTime;
    }

    public Integer getWindBearing() {
        return mWindBearingm;
    }

    public void setWindBearing(Integer windBearing) {
        this.mWindBearingm = windBearing;
    }

    public Double getCloudCover() {
        return mCloudCover;
    }

    public void setCloudCover(Double cloudCover) {
        this.mCloudCover = cloudCover;
    }

    public Integer getUvIndex() {
        return mUvIndex;
    }

    public void setUvIndex(Integer uvIndex) {
        this.mUvIndex = uvIndex;
    }

    public Integer getUvIndexTime() {
        return mUvIndexTime;
    }

    public void setUvIndexTime(Integer uvIndexTime) {
        this.mUvIndexTime = uvIndexTime;
    }

    public Double getVisibility() {
        return mVisibility;
    }

    public void setVisibility(Double visibility) {
        this.mVisibility = visibility;
    }

    public Double getOzone() {
        return mOzone;
    }

    public void setOzone(Double ozone) {
        this.mOzone = ozone;
    }

    public Double getTemperatureMin() {
        return mTemperatureMin;
    }

    public void setTemperatureMin(Double temperatureMin) {
        this.mTemperatureMin = temperatureMin;
    }

    public Integer getTemperatureMinTime() {
        return mTemperatureMinTime;
    }

    public void setTemperatureMinTime(Integer temperatureMinTime) {
        this.mTemperatureMinTime = temperatureMinTime;
    }

    public Double getTemperatureMax() {
        return mTemperatureMax;
    }

    public void setTemperatureMax(Double temperatureMax) {
        this.mTemperatureMax = temperatureMax;
    }

    public Integer getTemperatureMaxTime() {
        return mTemperatureMaxTime;
    }

    public void setTemperatureMaxTime(Integer temperatureMaxTime) {
        this.mTemperatureMaxTime = temperatureMaxTime;
    }

    public Double getApparentTemperatureMin() {
        return mApparentTemperatureMin;
    }

    public void setApparentTemperatureMin(Double apparentTemperatureMin) {
        this.mApparentTemperatureMin = apparentTemperatureMin;
    }

    public Integer getApparentTemperatureMinTime() {
        return mApparentTemperatureMinTime;
    }

    public void setApparentTemperatureMinTime(Integer apparentTemperatureMinTime) {
        this.mApparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    public Double getApparentTemperatureMax() {
        return mApparentTemperatureMax;
    }

    public void setApparentTemperatureMax(Double apparentTemperatureMax) {
        this.mApparentTemperatureMax = apparentTemperatureMax;
    }

    public Integer getApparentTemperatureMaxTime() {
        return mApparentTemperatureMaxTime;
    }

    public void setApparentTemperatureMaxTime(Integer apparentTemperatureMaxTime) {
        this.mApparentTemperatureMaxTime = apparentTemperatureMaxTime;
    }

}
