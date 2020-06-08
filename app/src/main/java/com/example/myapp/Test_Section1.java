package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Test_Section1 extends AppCompatActivity {
    User user;
    Button but1,but2,but3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__section1);

        user=getIntent().getParcelableExtra("user");
        but1=findViewById(R.id.test_section1_but1);
        but2=findViewById(R.id.test_section1_but2);
        but3=findViewById(R.id.test_section1_but3);

        but1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Context context=Test_Section1.this;
                Class TestSection1Theme1Class=TestSection1Theme1.class;
                Intent intent=new Intent(context,TestSection1Theme1Class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
        but2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Context context=Test_Section1.this;
                Class TestSection1Theme2Class=TestSection1Theme2.class;
                Intent intent=new Intent(context,TestSection1Theme2Class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
        but3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Context context=Test_Section1.this;
                Class TestSection1Theme3Class=TestSection1Theme3.class;
                Intent intent=new Intent(context,TestSection1Theme3Class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
    }
}
