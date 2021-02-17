package com.jk.onetoday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Diary_Tap1calender_feel extends AppCompatActivity {

    int year, month, dayOfMonth, ivImg;
    String feeltext;

    ArrayList<Diary_Tap1calender_feel_item> items= new ArrayList<>();
    RecyclerView recyclerView;
    Diary_Tap1calender_feel_Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_tap1calender_feel);

        Intent intent= getIntent();
        year= intent.getIntExtra("year",0);
        month= intent.getIntExtra("month",0);
        dayOfMonth= intent.getIntExtra("dayOfMonth",0);


        items.add( new Diary_Tap1calender_feel_item(R.drawable.dogtest,"강아지")  );

        recyclerView= findViewById(R.id.recycler);
        adapter= new Diary_Tap1calender_feel_Adapter(this, items);
        recyclerView.setAdapter(adapter);


        Toast.makeText(this, ""+year+"-"+month+"-"+dayOfMonth, Toast.LENGTH_SHORT).show();





    }

    public void clickfeelnext(View view) {
        Toast.makeText(this, "clickfeelnext", Toast.LENGTH_SHORT).show();

        Intent intentget=getIntent();
        feeltext= intentget.getStringExtra("feeltext");
        ivImg= intentget.getIntExtra("ivImg",0);

        Intent intent= new Intent(this, Diary_Tap1calender_Write.class);
        intent.putExtra("year", year);
        intent.putExtra("month", month);
        intent.putExtra("dayOfMonth", dayOfMonth);
        intent.putExtra("feeltext",feeltext);
        intent.putExtra("ivImg",ivImg);
        startActivity(intent);



    }
}