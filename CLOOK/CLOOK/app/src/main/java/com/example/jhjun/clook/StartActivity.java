package com.example.jhjun.clook;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.RelativeLayout;

import com.tmall.ultraviewpager.UltraViewPager;

/**
 * Created by jhjun on 2017-07-14.
 */

public class StartActivity extends Activity{
    UltraViewPager mUltraViewPager;
    pagerAdapter mPagerAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        mUltraViewPager = (UltraViewPager) findViewById(R.id.pager);
        mPagerAdapter = new pagerAdapter();

        mUltraViewPager.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mUltraViewPager.setScrollMode(UltraViewPager.ScrollMode.VERTICAL);
        mUltraViewPager.setAdapter(mPagerAdapter);

    }
}
