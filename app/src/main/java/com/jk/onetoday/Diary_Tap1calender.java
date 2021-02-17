package com.jk.onetoday;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Diary_Tap1calender extends Fragment{

    long now= System.currentTimeMillis();
//    Date mDate= new Date(now);
//
//    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
//    String getTime = simpleDate.format(mDate);

    CalendarView calendarView;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tab1_calender,container,false);

//        Toast.makeText(getActivity(), ""+ getTime, Toast.LENGTH_SHORT).show();

        //선택할수있는 최대 날짜
        calendarView = view.findViewById(R.id.calendarView);
        calendarView.setMaxDate(now);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getActivity(), year+"-"+month+"-"+dayOfMonth, Toast.LENGTH_SHORT).show();

                Intent intent= new Intent(getActivity(), Diary_Tap1calender_feel.class);
                intent.putExtra("year", year);
                intent.putExtra("month", month);
                intent.putExtra("dayOfMonth", dayOfMonth);
                startActivity(intent);
            }
        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //여기서 xml의 뷰들에 대한 find 참조.
    }
}
