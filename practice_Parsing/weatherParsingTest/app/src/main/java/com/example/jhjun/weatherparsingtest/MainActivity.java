package com.example.jhjun.weatherparsingtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.jhjun.weatherparsingtest.domain.Data;
import com.example.jhjun.weatherparsingtest.domain.Hourly;
import com.example.jhjun.weatherparsingtest.domain.Temperature;
import com.example.jhjun.weatherparsingtest.domain.Weather;
import com.example.jhjun.weatherparsingtest.util.Remote;
import com.example.jhjun.weatherparsingtest.util.TaskInterface;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements TaskInterface{


    static final String URL_WEATHER_PREFIX = "http://apis.skplanetx.com/weather/current/hourly?";
    static final String URL_VERSION = "version=1";
    static final String URL_LAT = "&lat=";
    static final String URL_LON = "&lon=";
    static final String URL_Default = "&city=&county=&village=";

    // 요청 URL : http://apis.skplanetx.com/weather/current/hourly?version=1&lat=37.4870600000&lon=127.0460400000&city=&county=&village=

    String WeatherInfoUrl = "";  // 날씨 정보를 얻기 위한 URL주소

    TextView textTemper;

    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setWeatherInfoUrl(37.4870600000, 127.0460400000);
        Remote.newTask(this);  // Remote 클래스의 newTask 메소드로 현재 액티비티의 정보를 보낸다.
                              // -> 수신 측은 내가 보낸 정보를 인터페이스로 받기 때문에 TaskInterface의 정의한 메소드 정보만을 사용한다.

        textTemper = (TextView) findViewById(R.id.textTemper);

        //Hourly hourly[] = data.getWeather().getHourly();
        //String temp = hourly[0].getTemperature().getTc();
        //textTemper.setText(temp);
    }

    private void setWeatherInfoUrl (double lat, double lon){
        WeatherInfoUrl = URL_WEATHER_PREFIX + URL_VERSION + URL_LAT + lat + URL_LON + lon + URL_Default;
    }

    @Override
    public String getUrl() {
        return WeatherInfoUrl;
    }

    @Override
    public void postExecute(String jsonString) {
        data = convertJson(jsonString);  // * 요청에 의한 결과값이 Data 클래스에 들어갔다.
        Log.e("Main", "data ====== " + data.toString());
        Hourly[] hourly = data.getWeather().getHourly();
        textTemper.setText(hourly[0].getTemperature().getTc());
        // Remote.newTask(this);
    }

    public Data convertJson(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Data.class);
    }
}
