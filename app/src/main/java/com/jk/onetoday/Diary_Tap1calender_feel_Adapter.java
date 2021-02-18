package com.jk.onetoday;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Diary_Tap1calender_feel_Adapter extends RecyclerView.Adapter{


    Context context;
    ArrayList<Diary_Tap1calender_feel_item> items;

    public Diary_Tap1calender_feel_Adapter(Context context, ArrayList<Diary_Tap1calender_feel_item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);

        View itemView= inflater.inflate(R.layout.activity_diary_tap1calender_feel_adapter_item, parent, false);
        VH holder= new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH)holder;

        //대입할 데이터 요소객체(Item) 얻어오기
        Diary_Tap1calender_feel_item item= items.get(position);
        vh.feeltext.setText(item.feeltext);

        //이미지 설정 - gif, network 를 편하게 할 수 있는 이미지 외부 라이브러리 사용 : Glide or Picasso
        //vh.ivIcon.setImageResource(item.icon); //gif 파일은 움직이지 못함
        Glide.with(context).load(item.feelimg).into(vh.ivImg);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //아이템뷰 안에 있는 뷰들의 참조변수를 멤버로 가지는 클래스
    class VH extends RecyclerView.ViewHolder{

        TextView feeltext;
        ImageView ivImg;

        public VH(@NonNull View itemView) {
            super(itemView);

            feeltext= itemView.findViewById(R.id.feel_gridview_tv);
            ivImg= itemView.findViewById(R.id.feel_gridview_iv);

            //아이템뷰를 클릭했을 때..
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //클릭한 항목 위치(index 번호) 알아내기
                    int position= getLayoutPosition();
                    //Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();

                    //그 선택된 항목의 상세내역을 보여주는 새로운 화면(Activity)를 실행
                    //선택된 아이템의 name, img 정보를 전달해주기
                    String feeltext= items.get(position).feeltext;
                    int imgId= items.get(position).feelimg;

                    Intent intent= new Intent(context, Diary_Tap1calender_feel.class);
                    intent.putExtra("feeltext", feeltext);
                    intent.putExtra("imgId", imgId);


                }
            });


        }
    }
}






