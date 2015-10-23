package com.hw.bousman.exercises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Session3bActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session3b);

        Bundle b = getIntent().getExtras();

        Log.d("Name", b.getString("Name"));

        TextView tv = (TextView)findViewById(R.id.textView3b);

        tv.setText(b.getString("Name"));
    }
}
