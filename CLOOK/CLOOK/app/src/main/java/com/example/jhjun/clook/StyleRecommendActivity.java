package com.example.jhjun.clook;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class StyleRecommendActivity extends AppCompatActivity {

    ImageView imageView_StyleRecommend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_recommend);

        imageView_StyleRecommend = (ImageView) findViewById(R.id.imageView_StyleRecommend);
        Glide.with(this).load(R.drawable.style_wm_sun).into(imageView_StyleRecommend);
    }
}
