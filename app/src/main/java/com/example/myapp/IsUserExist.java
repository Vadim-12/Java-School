package com.example.myapp;

import android.os.AsyncTask;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class IsUserExist extends AsyncTask<String,Void,Answer2>  {
    @Override
    protected Answer2 doInBackground(String... strings) {
        Answer2 answer=new Answer2();
        String localhost = "192.168.0.104";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://"+ localhost)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserService userService=retrofit.create(UserService.class);
        try {
            Call<Answer2> call=userService.getAnswer(strings[0]);
            Response<Answer2> response=call.execute();
            answer.data=response.body().data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }
    private interface UserService{
        @GET("isuserexist.php")
        Call<Answer2> getAnswer(@Query("login") String login);
    }

}
class Answer2{
    String data;
}
