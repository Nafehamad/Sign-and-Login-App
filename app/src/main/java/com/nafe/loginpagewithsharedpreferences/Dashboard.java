package com.nafe.loginpagewithsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {


    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        setTitle("Home Page");
        textView = (TextView)findViewById(R.id.tv);
        Intent intent = getIntent();
        String yourFullName = intent.getStringExtra("FullName");
        textView.setText("Welcome "+yourFullName);
    }
}
