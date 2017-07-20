package com.example.jhjun.customdialogtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class openActivity extends AppCompatActivity {

    CustomDialog customDialog;

    TextView txtResult;
    Button btnOpen;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);

        txtResult = (TextView) findViewById(R.id.txtResult);
        btnOpen = (Button) findViewById(R.id.btnOpen);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog = new CustomDialog(openActivity.this);
                customDialog.show();
            }
        });

    }

    public void Setting(String data) {
        this.data = data;
        txtResult.setText(data);
        Log.e("openActivity","data=========================" + this.data);
    }
}
