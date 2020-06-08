package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class HelloUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_user);
        final EditText loginEdit=findViewById(R.id.login);
        final EditText passwordEdit=findViewById(R.id.password);
        final Button butInput=findViewById(R.id.but_inp);
        final Button butReg=findViewById(R.id.but_reg);
        final User user=new User();

        butInput.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                user.setLogin(loginEdit.getText().toString());
                user.setPassword(passwordEdit.getText().toString());
                //отправить запрос в базу данных и проверить, есть ли в ней пользователь с таким логином и паролем
                IsUserExist check=new IsUserExist();
                check.execute(user.getLogin());
                try {
                    if(check.get().data.equals("1")){
                        //check is user's password equals password in db
                        //and if yes then give information about user to object User
                        //go to main_menu

                        //do select
                        //find user with added login
                        //and then check if password is written correctly
                        SelectMode selectMode=new SelectMode(1,user.getLogin(),user.getPassword());

                        SelectAll selectAll=new SelectAll(getApplicationContext(),HelloUser.this,selectMode);
                        selectAll.execute(selectMode);
                    }else{
                        Toast toast=Toast.makeText(getApplicationContext(),"Wrong login or password",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        butReg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Context context=HelloUser.this;
                Class RegistrationClass=Registration.class;
                Intent RegistrationActivityIntent=new Intent(context,RegistrationClass);
                RegistrationActivityIntent.putExtra("user", user);
                startActivity(RegistrationActivityIntent);
            }
        });
    }
}
