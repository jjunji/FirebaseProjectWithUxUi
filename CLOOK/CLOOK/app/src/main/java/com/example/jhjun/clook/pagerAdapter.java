package com.example.jhjun.clook;

import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.zip.Inflater;

/**
 * Created by jhjun on 2017-07-14.
 */

public class pagerAdapter extends PagerAdapter{

    LinearLayout container;

    /**
     *
     * @return
     */
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());

//        ConstraintLayout constraintLayout = (ConstraintLayout)inflater.inflate(R.layout.activity_main,null);
        View currentLayout = null;

//        View constraintLayout = inflater.inflate(R.layout.activity_main,null);
//        View linearLayout = inflater.inflate(R.layout.activity_style_recommend,null);

        switch (position){
            case 0:
                currentLayout = inflater.inflate(R.layout.activity_main,null);
                break;
            case 1:
                currentLayout = inflater.inflate(R.layout.activity_style_recommend,null);
                break;
            default:
                break;
        }
        container.addView(currentLayout);

        return currentLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        View currentView= (View) object;
        container.removeView(currentView);
    }
}
