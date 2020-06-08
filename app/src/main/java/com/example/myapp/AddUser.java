package com.example.myapp;

import android.os.AsyncTask;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class AddUser extends AsyncTask<User,Void,Void> {
    @Override
    protected Void doInBackground(User... users) {
        String localhost = "192.168.0.104";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://"+ localhost)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Add userService=retrofit.create(Add.class);
        try {
            Call call=userService.insert("users",getValues(users[0]));
            call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private String getValues(User u){
        return "'"+u.getName()+"','"+u.getSurname()+"','"+u.getGroup()+"','"+u.getLogin()+"','"+u.getPassword()+"'";
    }
    interface Add{
        @GET("insert.php")
        Call<Answer3> SendRequest(@Query("table_name") String table_name,@Query("data") String data);
        @GET("insert.php")
        Call<Answer3> insert(
                @Query("table_name") String table,
                @Query("data") String data);
    }
}
class Answer3{

}