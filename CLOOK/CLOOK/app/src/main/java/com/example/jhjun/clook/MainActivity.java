package com.example.jhjun.clook;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jhjun.clook.UrlSettingPack.UrlSetting;
import com.example.jhjun.clook.domain.pojo_Short.Data_Short;
import com.example.jhjun.clook.domain.pojo_Short.Forecast3days;
import com.example.jhjun.clook.domain.pojo_Short.Temperature;
import com.example.jhjun.clook.domain.pojo_Today.Data;
import com.example.jhjun.clook.domain.pojo_Today.Hourly;
import com.example.jhjun.clook.util.Remote;
import com.example.jhjun.clook.util.TaskInterface;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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


public class MainActivity extends Fragment implements TaskInterface
{
    Data data;
    Data_Short data_short;

    //
    TextView txtTemperNow, txtTemperLow, txtTemperHigh; // 현재온도, 최저,최고 온도
    TextView txtToday, txtTimeNow; // 요일, 시간

    TextView txtTime_now, txtTime_10, txtTime_13, txtTime_16, txtTime_19, txtTime_22;
    TextView txtSky_now, txtSky_10, txtSky_13, txtSky_16, txtSky_19, txtSky_22;

    ImageView imageView_illust;  // 일러스트 이미지뷰

    TextView btnDetail; // 임시 디테일 페이지 이동 버튼

    Context context;

    public MainActivity() {
        super();
    }

    public static MainActivity newInstance(Context context){
        MainActivity mainActivity = new MainActivity();
        mainActivity.context = context;
        return mainActivity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main,container,false);
        init(view); // 초기 설정.
        dateSetting(); // 현재 요일,시간 설정.
        setWeatherInfoUrl(37.4870600000, 127.0460400000);

        // 호출 순으로 차례대로 Remote 클래스의 newTask() 메소드 수행.
        Remote.newTask(UrlSetting.WeatherTodayUri,this);  // Remote 클래스의 newTask 메소드로 현재 액티비티의 정보를 보낸다.
        Remote.newTask(UrlSetting.WeatherShortUri,this);  // -> 수신 측은 내가 보낸 정보를 인터페이스로 받기 때문에 TaskInterface 에 정의한 메소드 정보만을 사용한다.

        return view;
    }

    // 각 Api full 주소 세팅.
    private void setWeatherInfoUrl (double lat, double lon){
        UrlSetting.WeatherTodayUri = URL_WEATHER_PREFIX + URL_WEATHER_TODAY + URL_VERSION + URL_LAT + lat + URL_LON + lon + URL_Default;
        UrlSetting.WeatherShortUri = URL_WEATHER_PREFIX + URL_WEATHER_SHORT + URL_VERSION + URL_LAT + lat + URL_LON + lon + URL_Default;
        UrlSetting.WeatherMidUri = URL_WEATHER_PREFIX + URL_WEATHER_MID + URL_VERSION + URL_LAT + lat + URL_LON + lon + URL_Default;
        UrlSetting.WeatherSimpleUri = URL_WEATHER_PREFIX + URL_WEATHER_SIMPLE + URL_VERSION + URL_LAT + lat + URL_LON + lon + URL_Default;
    }


    public void init(View view){
        imageView_illust = (ImageView) view.findViewById(R.id.imageView_illust);
        Glide.with(this).load(R.drawable.illust).into(imageView_illust);

        txtTemperNow = (TextView) view.findViewById(R.id.txtTemperNow);
        txtTemperLow = (TextView) view.findViewById(R.id.txtTemperLow);
        txtTemperHigh = (TextView) view.findViewById(R.id.txtTemperHigh);

        txtToday = (TextView) view.findViewById(R.id.txtToday);
        txtTimeNow = (TextView) view.findViewById(R.id.txtTimeNow);

        btnDetail = (TextView) view.findViewById(R.id.btnDetail);
        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),DetailWeatherActivity.class);
                startActivity(intent);
            }
        });

        txtTime_now = (TextView) view.findViewById(R.id.txtTime_now);
        txtTime_10 = (TextView) view.findViewById(R.id.txtTime_10);
        txtTime_13 = (TextView) view.findViewById(R.id.txtTime_13);
        txtTime_16 = (TextView) view.findViewById(R.id.txtTime_16);
        txtTime_19 = (TextView) view.findViewById(R.id.txtTime_19);
        txtTime_22 = (TextView) view.findViewById(R.id.txtTime_22);

/*        txtSky_now = (TextView) findViewById(R.id.txtSky_Now);
        txtSky_10 = (TextView) findViewById(R.id.txtSky_10);
        txtSky_13 = (TextView) findViewById(R.id.txtSky_13);
        txtSky_16 = (TextView) findViewById(R.id.txtSky_16);
        txtSky_19 = (TextView) findViewById(R.id.txtSky_19);
        txtSky_22 = (TextView) findViewById(R.id.txtTime_22);*/
    }


    //
    public Data convertJson(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Data.class);
    }

    public Data_Short short_convertJson(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Data_Short.class);
    }


    // 인터페이스 메소드
    @Override
    public void execute(String jsonString, String url) {

        if(url.equals(UrlSetting.WeatherTodayUri)) {
            data = convertJson(jsonString);  // * 요청에 의한 결과값이 Data 클래스에 들어갔다.
            setPresentTime();
        }else if(url.equals(UrlSetting.WeatherShortUri)){
            data_short = short_convertJson(jsonString);
            setDailyTime();
        }
    }

    // 현재 날짜 & 시간
    public void dateSetting(){
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("E요일");
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm a");
        txtToday.setText(sdf.format(date));
        txtTimeNow.setText(sdf2.format(date));
    }

    public void setPresentTime(){

        Hourly[] hourly = data.getWeather().getHourly();
        txtTemperLow.setText(hourly[0].getTemperature().getTmin());
        txtTemperHigh.setText(hourly[0].getTemperature().getTmax());
        txtTime_now.setText(hourly[0].getTemperature().getTc());
        txtTemperNow.setText(hourly[0].getTemperature().getTc());
    }

    public void setDailyTime(){
        Forecast3days[] forecast3dayses = data_short.getWeather().getForecast3days();

        txtTime_10.setText(forecast3dayses[0].getFcst3hour().getTemperature().getTemp10hour());
        txtTime_13.setText(forecast3dayses[0].getFcst3hour().getTemperature().getTemp13hour());
        txtTime_16.setText(forecast3dayses[0].getFcst3hour().getTemperature().getTemp16hour());
        txtTime_19.setText(forecast3dayses[0].getFcst3hour().getTemperature().getTemp19hour());
        txtTime_22.setText(forecast3dayses[0].getFcst3hour().getTemperature().getTemp22hour());
    }

    public void setSky(){
        Forecast3days[] forecast3dayses = data_short.getWeather().getForecast3days();

    }

}













/*        Intent intent = new Intent();
        String position = intent.getExtras().getString("spinnerPosition");*/