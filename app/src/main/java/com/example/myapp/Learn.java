package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Learn extends AppCompatActivity {
    private Button but1;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        user=getIntent().getParcelableExtra("user");
        but1=findViewById(R.id.menu_learn_section1);

        but1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Context context=Learn.this;
                Class LearnSection1Class=Learn_Section1.class;
                Intent LearnSection1ActivityIntent=new Intent(context,LearnSection1Class);
                LearnSection1ActivityIntent.putExtra("user",user);
                startActivity(LearnSection1ActivityIntent);
            }
        });

    }
}
