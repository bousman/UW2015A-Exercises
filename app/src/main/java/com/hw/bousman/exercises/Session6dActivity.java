package com.hw.bousman.exercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Session6dActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session6d);

        // Display SettingsFragment as the main content
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new SettingsFragment())
                .commit();
    }
}
