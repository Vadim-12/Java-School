package com.example.myapp;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String name,surname,group,login,password;
    public User(String name,String surname,String group,String login,String password){
        this.name=name;
        this.surname=surname;
        this.group=group;
        this.login=login;
        this.password=password;
    }
    public User(){
        this.name=null;
        this.surname=null;
        this.group=null;
        this.login=null;
        this.password=null;
    }

    protected User(Parcel in) {
        name = in.readString();
        surname = in.readString();
        group = in.readString();
        login = in.readString();
        password = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    //----------getters----------
    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public String getGroup(){
        return this.group;
    }
    public String getLogin(){
        return this.login;
    }
    public String getPassword(){
        return this.password;
    }
    public User getObject(){
        return this;
    }
    //---------setters----------
    public void setName(String s){
        this.name=s;
    }
    public void setSurname(String s){
        this.surname=s;
    }
    public void setGroup(String s){
        this.group=s;
    }
    public void setLogin(String s){
        this.login=s;
    }
    public void setPassword(String s){
        this.password=s;
    }
    public boolean isNullCheckAllFields(){
        if(this.name.equals("") || this.surname.equals("") || this.group.equals("") || this.login.equals("") || this.password.equals(""))
            return true;
        else
            return false;
    }
    public boolean isNullCheckOneField(String f){
        boolean b=false;
        switch (f){
            case "name":
                if(this.name==null)
                    b=true;
                else
                    b=false;
            case "surname":
                if(this.surname==null)
                    b=true;
                else
                    b=false;
            case "group":
                if(this.group==null)
                    b=true;
                else
                    b=false;
            case "login":
                if(this.login==null)
                    b=true;
                else
                    b=false;
            case "password":
                if(this.password==null)
                    b=true;
                else
                    b=false;
        }
        return b;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeString(group);
        dest.writeString(login);
        dest.writeString(password);
    }
}
