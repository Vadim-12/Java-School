package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Test extends AppCompatActivity {
    private Button but1;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        user=getIntent().getParcelableExtra("user");
        but1=findViewById(R.id.menu_test_section1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=Test.this;
                Class TestSection1Class=Test_Section1.class;
                Intent TestSection1ActivityIntent=new Intent(context,TestSection1Class);
                TestSection1ActivityIntent.putExtra("user",user);
                startActivity(TestSection1ActivityIntent);
            }
        });
    }
}
