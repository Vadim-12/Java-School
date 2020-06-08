package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button but1, but2, but3, but4;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=getIntent().getParcelableExtra("user");
        but1 = findViewById(R.id.menu_learn);
        but2 = findViewById(R.id.menu_test);
        but3 = findViewById(R.id.menu_options);
        but4 = findViewById(R.id.menu_exit);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = MainActivity.this;
                Class LearnClass = Learn.class;
                Intent LearnActivityIntent = new Intent(context, LearnClass);
                LearnActivityIntent.putExtra("user",user);
                startActivity(LearnActivityIntent);
            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = MainActivity.this;
                Class TestClass = Test.class;
                Intent TestActivityIntent = new Intent(context, TestClass);
                TestActivityIntent.putExtra("user",user);
                startActivity(TestActivityIntent);
            }
        });

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = MainActivity.this;
                Class OptionsClass = Options.class;
                Intent OptionsActivityIntent = new Intent(context, OptionsClass);
                OptionsActivityIntent.putExtra("user",user);
                startActivity(OptionsActivityIntent);
            }
        });

        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ExitIntent = new Intent(Intent.ACTION_MAIN);
                ExitIntent.addCategory(Intent.CATEGORY_HOME);
                ExitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(ExitIntent);
            }
        });


    }
}
