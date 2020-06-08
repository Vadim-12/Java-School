package com.example.myapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class TakeText extends AsyncTask<Void,Void,TakeText.Answer4> {
    interface SqlQuery{
        @GET("taketext.php")
        Call<Answer4> getAnswer(@Query("section_number") String section_number,@Query("theme_number") String theme_number);
    }
    TextMode textMode;
    public TakeText(TextMode textMode){
        this.textMode=textMode;
    }
    @Override
    protected Answer4 doInBackground(Void... voids) {
        Answer4 answer=new Answer4();
        String localhost="192.168.0.104";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://"+localhost)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TakeText.SqlQuery userService=retrofit.create(TakeText.SqlQuery.class);
        try {
            Call<Answer4> call=userService.getAnswer(this.textMode.num_sec,this.textMode.num_theme);
            Response<Answer4> response=call.execute();
            answer=response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    @Override
    protected void onPostExecute(Answer4 answer) {
        switch(this.textMode.num_sec){
            case "1":
                switch(this.textMode.num_theme){
                    case "1":
                        this.textMode.textViews.get(0).setText((answer.getHeader()));
                        this.textMode.textViews.get(1).setText(answer.getText());
                        break;
                    case "2":
                        this.textMode.textViews.get(0).setText((answer.getHeader()));
                        this.textMode.textViews.get(1).setText(answer.getText());
                        break;
                    case "3":
                        this.textMode.textViews.get(0).setText((answer.getHeader()));
                        this.textMode.textViews.get(1).setText(answer.getText());
                        break;
                }
                break;
        }
    }

    class Answer4{
        String sql;
        Boolean status;
        ArrayList<Text> data;
        void setData(ArrayList<Text> data){
            this.data=data;
        }
        ArrayList<Text> getData(){
            return this.data;
        }
        String getHeader(){
            String res=data.get(0).header;
            return res;
        }
        String getText(){
            String res=data.get(0).text;
            return res;
        }
    }
    class Text{
        int topic_number;
        String header,text;
    }
}
