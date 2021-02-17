package com.jk.onetoday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class MemoAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Memoitem> items;



    public MemoAdapter(Context context, ArrayList<Memoitem> items) {
        this.context = context;
        this.items = items;
    }

    //재활용할 뷰가 없어서 만들어야 할때 자동으로 실행되는 메소드
    //항목뷰를 만들고 참조값을 가진 ViewHolder를 리턴해주는 메소드
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);

        View itemView= inflater.inflate(R.layout.memo_item, parent, false);
        VH holder= new VH(itemView);

        return holder;
    }

    //해당위치(position)의 항목뷰에 items의 값 연결하는 메소드
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //첫번째 파라미터 holder 가 가진 뷰들 참조변수를 통해 값 설정
        VH vh= (VH)holder;

        //현재번째 아이템요소를 얻어와서 뷰들에 설정
        Memoitem item= items.get(position);
        vh.tvtitle.setText(item.title);
        vh.tvcontents.setText(item.contents);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    //inner class..
    //항목뷰 안에 있는 자식뷰들의 참조변수들을 저장하는 클래스
    class VH extends RecyclerView.ViewHolder {
        TextView tvtitle;
        TextView tvcontents;

        public VH(@NonNull View itemView) {
            super(itemView);

            tvtitle= itemView.findViewById(R.id.tv_title);
            tvcontents= itemView.findViewById(R.id.tv_contents);

            //파라미터 받은 항목뷰 (itemView) 클릭리스너 설정
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //현재 클릭한 위치 얻어내기
                    int position = getAdapterPosition();

                    Memoitem item = items.get(position);
                    Snackbar.make(v ,item.title +"\n"+item.contents , Snackbar.LENGTH_LONG).show();


                }

            });

        }

    }



}
