package com.example.jhjun.clook;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.tmall.ultraviewpager.UltraViewPager;

/**
 * Created by jhjun on 2017-07-14.
 */

public class StartActivity extends AppCompatActivity {
    UltraViewPager ultraViewPager;
    pagerAdapter adapter;
    //Context context = this;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        ultraViewPager = (UltraViewPager) findViewById(R.id.pager);
        adapter = new pagerAdapter(getSupportFragmentManager(),this);

        ultraViewPager.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.VERTICAL);

        ultraViewPager.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
