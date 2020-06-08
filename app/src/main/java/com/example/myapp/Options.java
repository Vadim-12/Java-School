package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Options extends AppCompatActivity {
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        user=getIntent().getParcelableExtra("user");
    }
}
