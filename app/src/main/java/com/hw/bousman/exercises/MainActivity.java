
package com.hw.bousman.exercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton(View view) {
        //Toast.makeText(MainActivity.this, "Clicked1", Toast.LENGTH_SHORT).show();
        int id = view.getId();
        if ( id == R.id.session4) {
            Intent explicitIntent = new Intent(MainActivity.this, Session4Activity.class);
            startActivity(explicitIntent);
        }

    }

}
