package com.hw.bousman.exercises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.Toast;

public class Session4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session4);

        // Get a reference to the AutoCompleteTextView in the layout
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocomplete_country);
        // Get the string array
        String[] countries = getResources().getStringArray(R.array.countries_array);
        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        textView.setAdapter(adapter);


        CheckBox box1 = (CheckBox) findViewById(R.id.checkbox_feature1);
        box1.setChecked(true);
    }

    public void onCheckBoxClicked(View view) {
        int id = view.getId();
        boolean newState = !((CheckBox) view).isChecked();
        int otherId;
        if (id == R.id.checkbox_feature1) {
            otherId = R.id.checkbox_feature2;
        }
        else{
            otherId = R.id.checkbox_feature1;
        }
        CheckBox otherBox = (CheckBox)findViewById(otherId);
        otherBox.setChecked(newState);
    }
}
