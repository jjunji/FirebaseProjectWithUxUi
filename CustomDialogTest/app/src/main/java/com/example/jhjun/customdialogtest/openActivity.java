package com.example.jhjun.customdialogtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        txtResult.setText(data);
    }

    public void Setting(String data) {
        this.data = data;
    }
}
