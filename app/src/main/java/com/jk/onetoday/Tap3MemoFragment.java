package com.jk.onetoday;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Tap3MemoFragment extends Fragment {

    ArrayList<Memoitem> memoitems= new ArrayList<>();
    RecyclerView recyclerView;
    MemoAdapter adapter;

    private FirebaseAuth firebaseAuth;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tab3,container,false);

        Toolbar toolbar= view.findViewById(R.id.toolbar3);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        recyclerView= view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MemoAdapter(getActivity(), memoitems);
        recyclerView.setAdapter(adapter); // 리사이클러뷰에 어댑터 연결

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String userID = user.getUid();

        // memoitems.add(new Memoitem("aaa","aaaaa") );

        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
        DatabaseReference rootRef= firebaseDatabase.getReference(userID);

        rootRef.child("Memoitems").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // 클래스 모델이 필요?
                for (DataSnapshot fileSnapshot : dataSnapshot.getChildren()) {
//                    String memoitems = fileSnapshot.child("filename").getValue(String.class);
//                    Log.i("TAG: value is ", memoitems);
//                    memoitems.add(memoitems);
//                    adapter.notifyDataSetChanged();
                    Memoitem person = fileSnapshot.getValue(Memoitem.class);
                    memoitems.add(0,person);
                    adapter.notifyItemInserted(memoitems.size());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG: ", "Failed to read value", databaseError.toException());
            }
        });





        return view;
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
        inflater1.inflate(R.menu.option_tab3,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id= item.getItemId();

        switch (id){
            case R.id.Memo_add:
                Intent intent= new Intent(getActivity(), Memo_Write_Activity.class);
                startActivity(intent);

                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
