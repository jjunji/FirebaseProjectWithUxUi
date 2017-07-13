package com.example.jhjun.clook;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GoProductActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imageView_MIXXO, imageView_Zara, imageView_8sc, imageView_HnM, imageView_TOPSHOP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_product);

        init();
        setView(); // 이미지 세팅.

    }

    public void init(){
        imageView_MIXXO = (ImageView) findViewById(R.id.imageView_MIXXO);
        imageView_MIXXO.setOnClickListener(this);
        imageView_HnM = (ImageView) findViewById(R.id.imageView_HnM);
        imageView_8sc = (ImageView) findViewById(R.id.imageView_8sc);
        imageView_Zara = (ImageView) findViewById(R.id.imageView_Zara);
        imageView_TOPSHOP = (ImageView) findViewById(R.id.imageView_TOPSHOP);
    }

    public void setView(){
        Glide.with(this).load(R.drawable.mixxo).into(imageView_MIXXO);
        Glide.with(this).load(R.drawable.hnm).into(imageView_HnM);
        Glide.with(this).load(R.drawable.zara).into(imageView_Zara);
        Glide.with(this).load(R.drawable.eightsc).into(imageView_8sc);
        Glide.with(this).load(R.drawable.topshop).into(imageView_TOPSHOP);
    }

    @Override
    public void onClick(View v) {
        switch ( v.getId() ){
            case R.id.imageView_MIXXO :
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m-mixxo.elandmall.com/main/initMain.action"));
                startActivity(intent);
                break;
            case R.id.imageView_HnM :
                break;
            case R.id.imageView_8sc :
                break;
            case R.id.imageView_TOPSHOP :
                break;
            case R.id.imageView_Zara :
                break;
        }
    }
}
