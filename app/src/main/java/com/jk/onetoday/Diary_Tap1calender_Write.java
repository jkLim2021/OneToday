package com.jk.onetoday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Diary_Tap1calender_Write extends AppCompatActivity {

    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_tap1calender_write);

        Intent intentget=getIntent();
        int year= intentget.getIntExtra("year",0);
        int month= intentget.getIntExtra("month",0);
        int dayOfMonth= intentget.getIntExtra("dayOfMonth",0);
        String feeltext= intentget.getStringExtra("feeltext");
        int ivImg= intentget.getIntExtra("ivImg",0);

        textView= findViewById(R.id.date);
        imageView= findViewById(R.id.calendar_feel_img);

        textView.setText(year+"-"+month+"-"+dayOfMonth+"\n"+feeltext+"\n"+ivImg);

    }
}