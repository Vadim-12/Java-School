package com.example.myapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class SelectAll extends AsyncTask<SelectMode,Void,Answer> {
    interface UserService{
        @GET("select.php")
        Call<Answer> getAnswer(@Query("table_name")String table_name);
    }
    private SelectMode selectMode;
    private Context context;
    private HelloUser activity;
    public SelectAll(Context context,HelloUser activity,SelectMode selectMode){
        this.selectMode=selectMode;
        this.context=context;
        this.activity=activity;
    }
    @Override
    protected Answer doInBackground(SelectMode... modes) {
        Answer answer=new Answer();
        String localhost="192.168.0.104";
        answer=new Answer();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://"+localhost)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserService userService=retrofit.create(UserService.class);
        try {
            Call<Answer> call=userService.getAnswer("users");
            Response<Answer> response=call.execute();
            answer=response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.selectMode=modes[0];
        return answer;
    }
    private User find(ArrayList<User> users,String login){
        User user=new User();
        for(User u:users){
            if(u.getLogin().equals(login)){
                user=u;
            }
        }
        return user;
    }
    @Override
    protected void onPostExecute(Answer answer){
        //System.out.println(answer.getString());
        switch(this.selectMode.mode){
            case 1:
                ArrayList<User> data=new ArrayList<>(answer.getData());
                //find user with login pointed in SelectMode
                User user=find(data,this.selectMode.login);
                if(user.getPassword().equals(this.selectMode.password)){
                    //go to main_menu
                    Toast toast=Toast.makeText(this.context,"Signed in",Toast.LENGTH_SHORT);
                    toast.show();
                    Context HelloUserContext=this.activity;
                    Class MainActivityClass=MainActivity.class;
                    Intent MainActivityIntent=new Intent(HelloUserContext,MainActivityClass);
                    MainActivityIntent.putExtra("user",new User(user.getName(),user.getSurname(),user.getGroup(),user.getLogin(),user.getPassword()));
                    HelloUserContext.startActivity(MainActivityIntent);
                }else{
                    //print "wrong password"
                    Toast toast=Toast.makeText(context,"Wrong password",Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
        }
    }
}
class Answer{
    public String sql;
    public Boolean status;
    private ArrayList<User> data;
    public void setData(ArrayList<User> users){
        this.data = users;
    }
    ArrayList<User> getData(){
        return this.data;
    }
    public String getString(){
        String s="";
        for(User u:data){
            s+=u.getName()+" "+u.getSurname()+" "+u.getGroup()+" "+u.getGroup()+" "+u.getPassword()+"\n";
        }
        return s;
    }
}