package com.example.jhjun.clook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jhjun.clook.domain.Data;
import com.example.jhjun.clook.domain.Hourly;
import com.example.jhjun.clook.util.Remote;
import com.example.jhjun.clook.util.TaskInterface;
import com.google.gson.Gson;

public class IntroActivity extends AppCompatActivity{

    ImageView imageView_logo;
    ImageView btnStart;
    Spinner spinnerSex;
    Spinner spinnerAge;

    String position = ""; // 성별 스피너 눌린 위치 값

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        imageView_logo = (ImageView) findViewById(R.id.imageView_logo) ;
        Glide.with(this).load(R.drawable.logo).into(imageView_logo);

        btnStart = (ImageView) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this,MainActivity.class);
                //intent.putExtra("spinerPosition",position);
                startActivity(intent);
            }
        });

        spinnerSex = (Spinner) findViewById(R.id.spinnerSex);
        spinnerAge = (Spinner) findViewById(R.id.spinnerAge);

        String[] items = {"남자/여자", "남자", "여자"};
        String[] ageitmes = {"10/20/30", "10", "20", "30"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        ArrayAdapter<String> age_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ageitmes);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        age_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerSex.setAdapter(adapter);
        spinnerAge.setAdapter(age_adapter);

        spinnerSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int p, long id) {
                position = p+"";  // 스피너 클릭시 해당 포지션 값 기억.(bundle에 담아서 MainActivity.class로 보낼 것임.)
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}
