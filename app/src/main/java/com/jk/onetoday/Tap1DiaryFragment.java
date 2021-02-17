package com.jk.onetoday;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Tap1DiaryFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager pager;
    Tab1PagerAdapter pagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tab1,container,false);

        //Toolbar
        Toolbar toolbar= view.findViewById(R.id.toolbar1);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //여기서 xml의 뷰들에 대한 find 참조.
        tabLayout= view.findViewById(R.id.layout_tab1);

        pager= view.findViewById(R.id.pager1);
        pagerAdapter= new Tab1PagerAdapter(getFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        pager.setAdapter(pagerAdapter);

        //탭레이아웃과 뷰페이저를 연동
        tabLayout.setupWithViewPager(pager);
    }

    //Toolbar
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        MenuInflater inflater1= getActivity().getMenuInflater();
        inflater1.inflate(R.menu.option_tab1,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id= item.getItemId();

        switch (id){
            case R.id.Diary_settings:
//                Toast.makeText(getActivity(), "Diary_settings", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(getActivity(), Settings_Activity.class);
                startActivity(intent);


                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
