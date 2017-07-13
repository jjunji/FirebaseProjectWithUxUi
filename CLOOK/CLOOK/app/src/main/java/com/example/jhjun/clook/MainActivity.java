package com.example.jhjun.clook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jhjun.clook.domain.pojo_Today.Data;
import com.example.jhjun.clook.domain.pojo_Today.Hourly;
import com.example.jhjun.clook.util.Remote;
import com.example.jhjun.clook.util.TaskInterface;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.jhjun.clook.UrlSettingPack.UrlSetting.URL_Default;
import static com.example.jhjun.clook.UrlSettingPack.UrlSetting.URL_LAT;
import static com.example.jhjun.clook.UrlSettingPack.UrlSetting.URL_LON;
import static com.example.jhjun.clook.UrlSettingPack.UrlSetting.URL_VERSION;
import static com.example.jhjun.clook.UrlSettingPack.UrlSetting.URL_WEATHER_MID;
import static com.example.jhjun.clook.UrlSettingPack.UrlSetting.URL_WEATHER_PREFIX;
import static com.example.jhjun.clook.UrlSettingPack.UrlSetting.URL_WEATHER_SHORT;
import static com.example.jhjun.clook.UrlSettingPack.UrlSetting.URL_WEATHER_SIMPLE;
import static com.example.jhjun.clook.UrlSettingPack.UrlSetting.URL_WEATHER_TODAY;


public class MainActivity extends AppCompatActivity implements TaskInterface, View.OnClickListener{

    String WeatherInfoUrl = "";  // 날씨 정보를 얻기 위한 URL주소
    String WeatherTodayUri = ""; // 현재 날씨 URL
    String WeatherShortUri = ""; // 단기 날씨 URL
    String WeatherMidUri = ""; // 중기 예보 URL
    String WeatherSimpleUri = "";

    Data data;

    //
    TextView txtTemperNow, txtTemperLow, txtTemperHigh; // 현재온도, 최저,최고 온도
    TextView txtToday, txtTimeNow; // 요일, 시간
    //

    ImageView imageView_illust;  // 일러스트 이미지뷰

    TextView btnDetail; // 임시 디테일 페이지 이동 버튼
    TextView btnStyle_recommend;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init(); // 초기 설정.
        setListener(); // 리스너 세팅.
        dateSetting(); // 현재 요일,시간 설정.

        setWeatherInfoUrl(37.4870600000, 127.0460400000);
        Remote.newTask(this);  // Remote 클래스의 newTask 메소드로 현재 액티비티의 정보를 보낸다.
                                 // -> 수신 측은 내가 보낸 정보를 인터페이스로 받기 때문에 TaskInterface의 정의한 메소드 정보만을 사용한다.

    }


    public void init(){
        imageView_illust = (ImageView) findViewById(R.id.imageView_illust);
        Glide.with(this).load(R.drawable.illust).into(imageView_illust);

        txtTemperNow = (TextView) findViewById(R.id.txtTemperNow);
        txtTemperLow = (TextView) findViewById(R.id.txtTemperLow);
        txtTemperHigh = (TextView) findViewById(R.id.txtTemperHigh);

        txtToday = (TextView) findViewById(R.id.txtToday);
        txtTimeNow = (TextView) findViewById(R.id.txtTimeNow);

        btnDetail = (TextView) findViewById(R.id.btnDetail);
        btnStyle_recommend = (TextView) findViewById(R.id.btnStyle_recommend);
    }


    private void setListener() {
        btnDetail.setOnClickListener(this);
        btnStyle_recommend.setOnClickListener(this);
    }

    // 버튼(이미지뷰) 리스너
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDetail :
                intent = new Intent(MainActivity.this, DetailWeatherActivity.class);
                startActivity(intent);
                break;
            case R.id.btnStyle_recommend :
                intent = new Intent(MainActivity.this, StyleRecommendActivity.class);
                startActivity(intent);
                break;
        }
    }

    // 각 Api full 주소 세팅.
    private void setWeatherInfoUrl (double lat, double lon){
        WeatherTodayUri = URL_WEATHER_PREFIX + URL_WEATHER_TODAY + URL_VERSION + URL_LAT + lat + URL_LON + lon + URL_Default;
        WeatherShortUri = URL_WEATHER_PREFIX + URL_WEATHER_SHORT + URL_VERSION + URL_LAT + lat + URL_LON + lon + URL_Default;
        WeatherMidUri = URL_WEATHER_PREFIX + URL_WEATHER_MID + URL_VERSION + URL_LAT + lat + URL_LON + lon + URL_Default;
        WeatherSimpleUri = URL_WEATHER_PREFIX + URL_WEATHER_SIMPLE + URL_VERSION + URL_LAT + lat + URL_LON + lon + URL_Default;
    }
    //
    public Data convertJson(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Data.class);
    }

    // 인터페이스 메소드
    @Override
    public String getUrl() {
        return WeatherTodayUri;
    }

    // 인터페이스 메소드
    @Override
    public void postExecute(String jsonString) {
        data = convertJson(jsonString);  // * 요청에 의한 결과값이 Data 클래스에 들어갔다.

        Log.e("Main", "data ====== " + data.toString());
        Hourly[] hourly = data.getWeather().getHourly();
        txtTemperNow.setText(hourly[0].getTemperature().getTc());
        txtTemperLow.setText(hourly[0].getTemperature().getTmin());
        txtTemperHigh.setText(hourly[0].getTemperature().getTmax());

    }

    // 현재 날짜 & 시간
    public void dateSetting(){
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("E요일");
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm a");
        txtToday.setText(sdf.format(date));
        txtTimeNow.setText(sdf2.format(date));
    }

}


/*        Intent intent = new Intent();
        String position = intent.getExtras().getString("spinnerPosition");*/