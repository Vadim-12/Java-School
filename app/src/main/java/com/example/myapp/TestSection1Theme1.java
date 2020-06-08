package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TestSection1Theme1 extends AppCompatActivity {
    User user;
    EditText editText1,editText2,editText3,editText4,editText6_1,editText6_2,editText6_3;
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
    Button butCheck;
    LinearLayout linearLayout1,linearLayout2,linearLayout3,
            linearLayout4,linearLayout5,linearLayout6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_section1_theme1);

        user=getIntent().getParcelableExtra("user");
        editText1=findViewById(R.id.edit1);
        editText2=findViewById(R.id.edit2);
        editText3=findViewById(R.id.edit3);
        editText4=findViewById(R.id.edit4);
        checkBox1=findViewById(R.id.checkbox1);
        checkBox2=findViewById(R.id.checkbox2);
        checkBox3=findViewById(R.id.checkbox3);
        checkBox4=findViewById(R.id.checkbox4);
        editText6_1=findViewById(R.id.edit6_1);
        editText6_2=findViewById(R.id.edit6_2);
        editText6_3=findViewById(R.id.edit6_3);
        butCheck=findViewById(R.id.butcheck);

        linearLayout1=findViewById(R.id.layout1);
        linearLayout2=findViewById(R.id.layout2);
        linearLayout3=findViewById(R.id.layout3);
        linearLayout4=findViewById(R.id.layout4);
        linearLayout5=findViewById(R.id.layout5);
        linearLayout6=findViewById(R.id.layout6);

        butCheck.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //check tasks
                String answer1=editText1.getText().toString();
                String answer2=editText2.getText().toString();
                String answer3=editText3.getText().toString();
                String answer4=editText4.getText().toString();
                boolean answer5_1=checkBox1.isChecked();
                boolean answer5_2=checkBox2.isChecked();
                boolean answer5_3=checkBox3.isChecked();
                boolean answer5_4=checkBox4.isChecked();
                int s=0;
                if(answer5_1) ++s;
                if(answer5_2) ++s;
                if(answer5_3) ++s;
                if(answer5_4) ++s;
                String answer6_1=editText6_1.getText().toString();
                String answer6_2=editText6_2.getText().toString();
                String answer6_3=editText6_3.getText().toString();
                if(answer1.equals("") || answer2.equals("") || answer3.equals("") || answer4.equals("") || answer6_1.equals("") || answer6_2.equals("") || answer6_3.equals("")){
                    Toast toast=Toast.makeText(getApplicationContext(),"There are empty fields",Toast.LENGTH_SHORT);
                    toast.show();
                }else if(s!=1){
                    Toast toast=Toast.makeText(getApplicationContext(),"Choose only one answer in task 5",Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    int green=Color.parseColor("#C3F947");
                    int red=Color.parseColor("#F95218");
                    if(answer1.equals("System")){
                        linearLayout1.setBackgroundColor(green);
                    }else{
                        linearLayout1.setBackgroundColor(red);
                    }
                    if(answer2.equals("import")){
                        linearLayout2.setBackgroundColor(green);
                    }else{
                        linearLayout2.setBackgroundColor(red);
                    }
                    if(answer3.equals("main()")){
                        linearLayout3.setBackgroundColor(green);
                    }else{
                        linearLayout3.setBackgroundColor(red);
                    }
                    if(answer4.equals("first")){
                        linearLayout4.setBackgroundColor(green);
                    }else{
                        linearLayout4.setBackgroundColor(red);
                    }
                    if(!answer5_1 && !answer5_2 && answer5_3 && !answer5_4){
                        linearLayout5.setBackgroundColor(green);
                    }else{
                        linearLayout5.setBackgroundColor(red);
                    }
                    if(answer6_1.equals("public") && answer6_2.equals("main") && (answer6_3.equals("print") || answer6_3.equals("println"))){
                        linearLayout6.setBackgroundColor(green);
                    }else{
                        linearLayout6.setBackgroundColor(red);
                    }

                    //check answers
                    //we can create special TextViews near the user's answers and write there correct answers, also we can paint user's answers into green or red color
                }

            }
        });


    }
}
