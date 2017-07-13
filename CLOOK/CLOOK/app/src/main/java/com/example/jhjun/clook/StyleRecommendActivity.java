package com.example.jhjun.clook;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class StyleRecommendActivity extends AppCompatActivity {

    ImageView imageView_StyleRecommend;
    TextView btnGoProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_recommend);

        init();
        
        btnGoProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StyleRecommendActivity.this, GoProductActivity.class);
                startActivity(intent);
            }
        });
    }

    public void init(){
        btnGoProduct = (TextView) findViewById(R.id.btnGoProduct);
        imageView_StyleRecommend = (ImageView) findViewById(R.id.imageView_StyleRecommend);
        Glide.with(this).load(R.drawable.style_wm_sun).into(imageView_StyleRecommend);
    }
}
