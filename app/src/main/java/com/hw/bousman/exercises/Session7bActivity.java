package com.hw.bousman.exercises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Session7bActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session7b);

        Bundle b = getIntent().getExtras();
        ArrayList<String> dataTitles = b.getStringArrayList("database");

        ListView myListView = (ListView)findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, dataTitles);
        myListView.setAdapter(adapter);
    }
}
