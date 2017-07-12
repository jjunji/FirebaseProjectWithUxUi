package com.example.jhjun.clook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ImageView imageView_illust;  // 일러스트 이미지뷰

    TextView btnDetail; // 임시 디테일 페이지 이동 버튼
    TextView btnStyle_recommend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView_illust = (ImageView) findViewById(R.id.imageView_illust);
        Glide.with(this).load(R.drawable.illust).into(imageView_illust);

        btnDetail = (TextView) findViewById(R.id.btnDetail);
        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailWeatherActivity.class);
                startActivity(intent);
            }
        });

        btnStyle_recommend = (TextView) findViewById(R.id.btnStyle_recommend);
        btnStyle_recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StyleRecommendActivity.class);
                startActivity(intent);
            }
        });



    }
}


/*        Intent intent = new Intent();
        String position = intent.getExtras().getString("spinnerPosition");*/