package com.hw.bousman.exercises;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

public class Session6cActivity extends AppCompatActivity implements
        CompoundButton.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session6c);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String syncConnPref = sharedPref.getString("pref_enable_comm", "");
        TextView tv = (TextView)findViewById(R.id.prefsView);
        if ( tv != null ) {
            tv.setText(syncConnPref);
        }

        SwitchCompat switch1 = (SwitchCompat)findViewById(R.id.switch_compat);
        switch1.setOnCheckedChangeListener(this);
        SwitchCompat switch2 = (SwitchCompat)findViewById(R.id.switch_compat2);
        switch2.setOnCheckedChangeListener(this);
    }

    public static final String PREFS_NAME = "MyPrefsFile";
    private int mCounter = 0;

    @Override
    protected void onResume() {
        super.onResume();

        // Restore preferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        mCounter = settings.getInt("silentMode", 0);
        updateCounter(mCounter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("silentMode", mCounter);

        // Commit the edits!
        editor.commit();
    }


    public void onIncrementClick(View view) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("silentMode", ++mCounter);

        // Commit the edits!
        editor.commit();
    }

    public void onReadPref(View view) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        int counter = settings.getInt("silentMode", 0);
        updateCounter(counter);
    }

    public void updateCounter(int counter) {
        TextView tv = (TextView) findViewById(R.id.textView6c);
        if (tv != null) {
            tv.setText(Integer.toString(counter));
        }

    }



    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.switch_compat:
                Log.i("switch_compat", isChecked + "");
                break;
            case R.id.switch_compat2:
                Log.i("switch_compat2", isChecked + "");
                break;
        }

    }
}
