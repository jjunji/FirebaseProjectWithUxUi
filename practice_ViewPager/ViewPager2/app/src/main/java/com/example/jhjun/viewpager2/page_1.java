package com.example.jhjun.viewpager2;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by jhjun on 2017-07-09.
 */

public class page_1 extends android.support.v4.app.Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LinearLayout linearLayout=(LinearLayout)inflater.inflate(R.layout.activity_page,container,false);

        LinearLayout background=(LinearLayout)linearLayout.findViewById(R.id.background);
        TextView page_num=(TextView)linearLayout.findViewById(R.id.page_num);
        page_num.setText(String.valueOf(1));
        background.setBackground(new ColorDrawable(0xff6dc6d2));

        return linearLayout;
    }
}
