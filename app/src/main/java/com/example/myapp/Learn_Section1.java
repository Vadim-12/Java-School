package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Learn_Section1 extends AppCompatActivity {
    User user;
    Button but1,but2,but3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn__section1);

        but1=findViewById(R.id.learn_section1_but1);
        but2=findViewById(R.id.learn_section1_but2);
        but3=findViewById(R.id.learn_section1_but3);
        user=getIntent().getParcelableExtra("user");

        but1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context=Learn_Section1.this;
                Class LearnSection1Theme1=LearnSection1Theme1.class;
                Intent LearnSection1Theme1Intent=new Intent(context,LearnSection1Theme1);
                LearnSection1Theme1Intent.putExtra("user",user);
                startActivity(LearnSection1Theme1Intent);
            }
        });
        but2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context=Learn_Section1.this;
                Class LearnSection1Theme2=LearnSection1Theme2.class;
                Intent LearnSection1Theme2Intent=new Intent(context,LearnSection1Theme2);
                LearnSection1Theme2Intent.putExtra("user",user);
                startActivity(LearnSection1Theme2Intent);
            }
        });
        but3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context=Learn_Section1.this;
                Class LearnSection1Theme3=LearnSection1Theme3.class;
                Intent LearnSection1Theme3Intent=new Intent(context,LearnSection1Theme3);
                LearnSection1Theme3Intent.putExtra("user",user);
                startActivity(LearnSection1Theme3Intent);
            }
        });
    }
}
