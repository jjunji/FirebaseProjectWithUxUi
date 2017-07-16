package com.example.jhjun.clook;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by jhjun on 2017-07-14.
 */

public class pagerAdapter extends FragmentPagerAdapter
{
    //LinearLayout container;
    Context context;

    public pagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;  // StartActivity
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:  // MainFragment
                MainActivity mainActivity = MainActivity.newInstance(context);
                return mainActivity;
            case 1:  // styleRecommendActivity
                StyleRecommendActivity styleRecommendActivity = StyleRecommendActivity.newInstance(context);
                return styleRecommendActivity;
            default:
                return null;
        }
    }
}
