package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class LearnSection1Theme2 extends AppCompatActivity {
    User user;
    TextView textViewHeader;
    TextView textViewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_section1_theme2);

        textViewHeader=findViewById(R.id.learn_sec1_th2_header);
        textViewText=findViewById(R.id.learn_sec1_th2_text);
        ArrayList<TextView> arr=new ArrayList<>();
        arr.add(textViewHeader);
        arr.add(textViewText);
        TextMode textMode=new TextMode("1","2",arr);
        TakeText takeText=new TakeText(textMode);
        takeText.execute();
        user=getIntent().getParcelableExtra("user");
    }
}
