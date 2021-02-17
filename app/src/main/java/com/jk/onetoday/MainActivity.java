package com.jk.onetoday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;
    Fragment[] fragments= new Fragment[4];
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager= getSupportFragmentManager();

        //tab1이 기본 선택된 상태이므로
        //tab1Fragment부터 화면에 놓기
        FragmentTransaction tran=fragmentManager.beginTransaction();
        fragments[0]= new Tap1DiaryFragment();
        tran.add(R.id.container, fragments[0]);
        tran.commit();

        bnv= findViewById(R.id.bnv);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //기존 Fragment를 다른 Fragment로 변경[replace --> show/hide]
                FragmentTransaction tran= fragmentManager.beginTransaction();
                if(fragments[0]!=null) tran.hide(fragments[0]);
                if(fragments[1]!=null) tran.hide(fragments[1]);
                if(fragments[2]!=null) tran.hide(fragments[2]);
                if(fragments[3]!=null) tran.hide(fragments[3]);

                switch (item.getItemId()){
                    case R.id.bnv_tab1:
                        tran.show(fragments[0]);
                        break;

                    case R.id.bnv_tab2:
                        if(fragments[1]==null){
                            fragments[1]= new Tap2CulturalFragment();
                            tran.add(R.id.container, fragments[1]);
                        }
                        tran.show(fragments[1]);
                        break;

                    case R.id.bnv_tab3:
                        if(fragments[2]==null){
                            fragments[2]= new Tap3MemoFragment();
                            tran.add(R.id.container, fragments[2]);
                        }
                        tran.show(fragments[2]);
                        break;

                    case R.id.bnv_tab4:
                        if(fragments[3]==null){
                            fragments[3]= new Tap4GifticonFragment();
                            tran.add(R.id.container, fragments[3]);
                        }
                        tran.show(fragments[3]);
                        break;
                }

                tran.commit();

                return true;
            }
        });


    }
}