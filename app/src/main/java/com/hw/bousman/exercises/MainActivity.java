
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
        if ( id == R.id.session1) {
            Intent explicitIntent = new Intent(MainActivity.this, Session1Activity.class);
            startActivity(explicitIntent);
        }
        else if ( id == R.id.session2) {
            Intent explicitIntent = new Intent(MainActivity.this, Session2Activity.class);
            startActivity(explicitIntent);
        }
        else if ( id == R.id.session2b) {
            Intent explicitIntent = new Intent(MainActivity.this, Session2bActivity.class);
            startActivity(explicitIntent);
        }
        else if ( id == R.id.session2c) {
            Intent explicitIntent = new Intent(MainActivity.this, Session2cActivity.class);
            startActivity(explicitIntent);
        }
        else if ( id == R.id.session3) {
            Intent explicitIntent = new Intent(MainActivity.this, Session3Activity.class);
            startActivity(explicitIntent);
        }
        else if ( id == R.id.session4) {
            Intent explicitIntent = new Intent(MainActivity.this, Session4Activity.class);
            startActivity(explicitIntent);
        }
        else if ( id == R.id.session5) {
            Intent explicitIntent = new Intent(MainActivity.this, Session5Activity.class);
            startActivity(explicitIntent);
        }
        else if ( id == R.id.session5b) {
            Intent explicitIntent = new Intent(MainActivity.this, Session5bActivity.class);
            startActivity(explicitIntent);
        }
        else if ( id == R.id.session5c) {
            Intent explicitIntent = new Intent(MainActivity.this, Session5cActivity.class);
            startActivity(explicitIntent);
        }
        else if (id == R.id.session6) {
            Intent explicitIntent = new Intent(MainActivity.this, Session6Activity.class);
            startActivity(explicitIntent);
        }
        else if (id == R.id.session6b) {
            Intent explicitIntent = new Intent(MainActivity.this, Session6bActivity.class);
            startActivity(explicitIntent);
        }
        else if (id == R.id.session6c) {
            Intent explicitIntent = new Intent(MainActivity.this, Session6cActivity.class);
            startActivity(explicitIntent);
        }
        else if (id == R.id.session6d) {
            Intent explicitIntent = new Intent(MainActivity.this, Session6dActivity.class);
            startActivity(explicitIntent);
        }
        else if ( id == R.id.session7) {
            Intent explicitIntent = new Intent(MainActivity.this, Session7Activity.class);
            startActivity(explicitIntent);
        }
        else if ( id == R.id.session8) {
            Intent explicitIntent = new Intent(MainActivity.this, Session8Activity.class);
            startActivity(explicitIntent);
        }
        else if ( id == R.id.session9) {
            Intent explicitIntent = new Intent(MainActivity.this, Session9Activity.class);
            startActivity(explicitIntent);
        }
    }

}
