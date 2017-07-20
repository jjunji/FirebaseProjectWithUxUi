package com.example.jhjun.customdialogtest;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomDialog extends Dialog{

    openActivity activity;
    ImageView imgClose, imgSearch;

    RecyclerView recyclerView;
    String[] data = {"서울특별시", "경기도", "부산광역시", "강원도", "충청남도", "전라남도", "전라북도"};
    CustomRecyclerViewAdapter adapter;

    public CustomDialog(@NonNull openActivity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);

        setContentView(R.layout.activity_custom_dialog);
        init();
    }

    class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.ViewHolder>{
        int position;
        String[] data;

        public CustomRecyclerViewAdapter(String[] data) {
            this.data = data;
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            //OnClickListener listener;
            TextView txtRegion;

            // TODO: 2017-07-20
            // Holder에 리스너를 달았을 때 생기는 문제점 과 onBindViewHolder에 리스너를 다는 경우를 구분하자.
            // -> Holder의 재사용성으로 인해 BInd에 위젯 세팅과 같이 리스너를 달아주는 것이 알맞다고 생각됨.
            
            public ViewHolder(View v) {
                super(v);
                txtRegion = (TextView) v.findViewById(R.id.txtRegion);
                //v.setOnClickListener((View.OnClickListener) listener);
            }
        }


        @Override
        public CustomRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final CustomRecyclerViewAdapter.ViewHolder holder, final int position) {

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.Setting(data[position]);
                }
            });

//            holder.txtRegion.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    activity.Setting(data[position]);
//                    Log.e("CustomDialog","data[position]============="+data[position]);
//                }
//            });
            holder.txtRegion.setText(data[position]);
        }

        @Override
        public int getItemCount() {
            return data.length;
        }

    }

    public void init() {
        imgClose = (ImageView) findViewById(R.id.imgClose);
        imgSearch = (ImageView) findViewById(R.id.imgSearch);

        imgSearch.setImageResource(R.drawable.search_icon);
        imgClose.setImageResource(R.drawable.close_icon);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new CustomRecyclerViewAdapter(data);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
    }
}
