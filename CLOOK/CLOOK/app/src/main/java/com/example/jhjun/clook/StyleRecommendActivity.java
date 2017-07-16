package com.example.jhjun.clook;


import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.Nullable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class StyleRecommendActivity extends Fragment {

    ImageView imageView_StyleRecommend;
    TextView btnGoProduct;

    Context context;

    public StyleRecommendActivity() {
        super();
    }

    public static StyleRecommendActivity newInstance(Context context){
        StyleRecommendActivity styleRecommendActivity = new StyleRecommendActivity();
        styleRecommendActivity.context = context;
        return styleRecommendActivity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_style_recommend,container,false);
        init(view);

        btnGoProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GoProductActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


    public void init(View view){
        btnGoProduct = (TextView) view.findViewById(R.id.btnGoProduct);
        imageView_StyleRecommend = (ImageView) view.findViewById(R.id.imageView_StyleRecommend);
        Glide.with(this).load(R.drawable.style_wm_sun).into(imageView_StyleRecommend);
    }
}
