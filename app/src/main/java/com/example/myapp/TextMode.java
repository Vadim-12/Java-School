package com.example.myapp;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

public class TextMode {
    String num_sec,num_theme;
    ArrayList<TextView> textViews;
    public TextMode(String sec,String theme,ArrayList<TextView> textViews){
        this.num_sec=sec;
        this.num_theme=theme;
        this.textViews=textViews;
    }
}
