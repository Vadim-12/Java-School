package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class LearnSection1Theme1 extends AppCompatActivity {
    User user;
    TextView textViewHeader;
    TextView textViewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_section1_theme1);

        textViewHeader=findViewById(R.id.learn_sec1_th1_header);
        textViewText=findViewById(R.id.learn_sec1_th1_text);
        ArrayList<TextView> arr=new ArrayList<>();
        arr.add(textViewHeader);
        arr.add(textViewText);
        TextMode textMode=new TextMode("1","1",arr);
        TakeText takeText=new TakeText(textMode);
        takeText.execute();
        user=getIntent().getParcelableExtra("user");

    }
}