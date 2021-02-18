package com.jk.onetoday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Memo_Write_Activity extends AppCompatActivity {

    Toolbar toolbar3_write;

    EditText et_title, et_contents;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_write);

        toolbar3_write= findViewById(R.id.toolbar3_write);
        setSupportActionBar(toolbar3_write);

        et_title = findViewById(R.id.title);
        et_contents = findViewById(R.id.contents);

        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
        DatabaseReference rootRef= firebaseDatabase.getReference();

        Memoitem memo = new Memoitem();
        DatabaseReference personRef = rootRef.child("Memoitems");
        personRef.push().setValue(memo);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.option_tab3_write, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //OptionMenu 의 항목(MenuItem)을 선택하면
    //자동으로 발동하는 콜백 메소드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id= item.getItemId();

        switch (id){
            case R.id.Memo_check:

                saveData();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    void saveData(){

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String userID = user.getUid();

        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
        DatabaseReference rootRef= firebaseDatabase.getReference(userID);

        String title = et_title.getText().toString();
        String contents = et_contents.getText().toString();

        if (contents==null) return;

        Memoitem memo = new Memoitem(title, contents);
        DatabaseReference personRef = rootRef.child("Memoitems");
        personRef.push().setValue(memo);

        Intent intent= new Intent(this, MainActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("contents", contents);
        startActivity(intent);


    }

}