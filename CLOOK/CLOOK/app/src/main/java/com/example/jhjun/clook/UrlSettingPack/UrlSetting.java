package com.example.jhjun.clook.UrlSettingPack;

/**
 * Created by jhjun on 2017-07-13.
 */

public class UrlSetting {

    // api 호출 시 공통으로 들어가야하는 부분.
    public static final String URL_WEATHER_PREFIX = "http://apis.skplanetx.com/weather/";
    public static final String URL_VERSION = "version=1"; // 공통(필수)
    public static final String URL_LAT = "&lat=";  // 공통(필수)
    public static final String URL_LON = "&lon=";  // 공통(필수)
    public static final String URL_Default = "&city=&county=&village="; // 공통

    // 현재날씨 api -> main(현재 구름,기온,최저,최고)
    public static final String URL_WEATHER_TODAY = "current/hourly?";

    //단기예보 api -> main(시간대 별 구름, 기온) / detail(+습도)
    public static final String URL_WEATHER_SHORT = "forecast/3days?";

    //중기예보 api -> detail_주간날씨(요일, 구름, 최저,최고) -> +3일 부터 제공 -> 간편날씨 api(1~3일치 제공) -> 중기 + 간편 으로 가공해 써야한다.
    public static final String URL_WEATHER_MID = "forecast/6days?";

    //간편날씨 api -> detail_주간날씨(요일, 구름, 최저,최고) -> 1~3일
    public static final String URL_WEATHER_SIMPLE = "summary?";

    public static String WeatherTodayUri = ""; // 현재 날씨 URL
    public static String WeatherShortUri = ""; // 단기 날씨 URL
    public static String WeatherMidUri = ""; // 중기 예보 URL
    public static String WeatherSimpleUri = "";  // 간편 날씨 URL

}
