package com.jk.onetoday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Memo_Detail_Activity extends AppCompatActivity {

    TextView title, contents;

    Toolbar toolbar3_Detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_detail);

        title = findViewById(R.id.title);
        contents = findViewById(R.id.contents);

        toolbar3_Detail = findViewById(R.id.toolbar3_detail);
        setSupportActionBar(toolbar3_Detail);

        Intent intentget = getIntent();
        String dbtitle = intentget.getStringExtra("title");
        String dbcontents = intentget.getStringExtra("contents");

        title.setText(dbtitle);
        contents.setText(dbcontents);

    }

    //toolbar3_Detail
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_tab3_detail, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //OptionMenu 의 항목(MenuItem)을 선택하면
    //자동으로 발동하는 콜백 메소드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.memo_correction:
                Toast.makeText(this, "memo_correction", Toast.LENGTH_SHORT).show();

                break;

            case R.id.memo_delete:
                Toast.makeText(this, "memo_delete", Toast.LENGTH_SHORT).show();

                break;

        }

        return super.onOptionsItemSelected(item);
    }

}