package com.hw.bousman.exercises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Session2cActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session2c);
    }

    public void sendMessage(View view) {
        Toast.makeText(Session2cActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
    }
}
