package com.example.jhjun.clook.UrlSettingPack;

/**
 * Created by jhjun on 2017-07-13.
 */

public class UrlSetting {
    public static final String URL_WEATHER_PREFIX = "http://apis.skplanetx.com/weather/";
    public static final String URL_VERSION = "version=1"; // 공통(필수)
    public static final String URL_LAT = "&lat=";  // 공통(필수)
    public static final String URL_LON = "&lon=";  // 공통(필수)
    public static final String URL_Default = "&city=&county=&village="; // 공통

    // 현재날씨 api
    public static final String URL_WEATHER_TODAY = "current/hourly?";

    //단기예보 Api
    public static final String URL_WEATHER_SHORT = "forecast/3days?";

    //중기예보 Api
    public static final String URL_WEATHER_MID = "forecast/6days?";

    //간편날씨 Api
    public static final String URL_WEATHER_SIMPLE = "summary?";


}
