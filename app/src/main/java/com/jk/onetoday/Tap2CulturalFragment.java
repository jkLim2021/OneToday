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

public class Tap2CulturalFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager pager;
    Tab2PagerAdapter pagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tab2,container,false);

        //Toolbar
        Toolbar toolbar= view.findViewById(R.id.toolbar2);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //여기서 xml의 뷰들에 대한 find 참조.
        tabLayout= view.findViewById(R.id.layout_tab2);

        pager= view.findViewById(R.id.pager2);
        pagerAdapter= new Tab2PagerAdapter(getFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
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

        MenuInflater inflater2= getActivity().getMenuInflater();
        inflater2.inflate(R.menu.option_tab2,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id= item.getItemId();

        switch (id){
            case R.id.menu_movie:
//                Toast.makeText(getActivity(), "menu_movie", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), Movie_Search_Activity.class);
                startActivity(intent);
                break;

            case R.id.menu_book:
                Toast.makeText(getActivity(), "menu_book", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
