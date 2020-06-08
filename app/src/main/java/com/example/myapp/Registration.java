package com.example.myapp;
import com.example.myapp.SelectAll;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;


public class Registration extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final EditText editName=findViewById(R.id.name);
        final EditText editSurname=findViewById(R.id.surname);
        final EditText editGroup=findViewById(R.id.group);
        final EditText editLogin=findViewById(R.id.login);
        final EditText editPassword=findViewById(R.id.password);
        final Button butReg=findViewById(R.id.reg);
        final User user=getIntent().getParcelableExtra("user");

        butReg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                assert user != null;
                user.setName(editName.getText().toString());
                user.setSurname(editSurname.getText().toString());
                user.setGroup(editGroup.getText().toString());
                user.setLogin(editLogin.getText().toString());
                user.setPassword(editPassword.getText().toString());
                //if there isn't repeat data then to add user to data baze
                if(user.isNullCheckAllFields()){
                    // print "there are empty fields"
                    System.out.println("null field or fields");
                }else{
                    IsUserExist isUserExist= new IsUserExist();
                    isUserExist.execute(user.getLogin());
                    //на момент вывода запрос еще не отправился и не обработался поэтому его как то надо связать с методом onPostExecute
                    //send request with parametr - user's login
                    try {
                        if(isUserExist.get().data.equals("1")/*ckeck is there user with such login*/){
                            //print "there is user with such login"
                            Toast toast=Toast.makeText(getApplicationContext(),"User with such login already exist",Toast.LENGTH_SHORT);
                            toast.show();
                            //System.out.println("already exists");
                        }else{
                            Toast toast=Toast.makeText(getApplicationContext(),"New user is added",Toast.LENGTH_SHORT);
                            toast.show();
                            AddUser addUser=new AddUser();
                            addUser.execute(user);

                            Context context=Registration.this;
                            Class HelloUserClass=HelloUser.class;
                            Intent HelloUserActivityIntent=new Intent(context,HelloUserClass);
                            startActivity(HelloUserActivityIntent);
                            //add new user in data_baze
                            //System.out.println("addUser");
                        }
                    } catch (ExecutionException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
