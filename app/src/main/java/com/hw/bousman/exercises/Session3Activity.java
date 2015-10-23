package com.hw.bousman.exercises;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Session3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session3);
        Log.d("Activity3", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity3", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Activity3", "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity3", "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity3", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity3", "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity3", "onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d("Activity3", "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Activity3", "onRestoreInstanceState");
    }

    public void createEmailIntent(final String toEmail,
                                  final String subject,
                                  final String message)
    {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_EMAIL,
                new String[] { toEmail });
        i.putExtra(Intent.EXTRA_SUBJECT, subject);
        i.putExtra(Intent.EXTRA_TEXT, message);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Session3Activity.this,
                    "There are no email clients installed.",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void onSendEmail(View view) {
        //Toast.makeText(MainActivity.this, "Clicked2", Toast.LENGTH_SHORT).show();
        createEmailIntent("bousman@gmail.com", "my android subject", "this is an email message");
    }

    public void onPassBundle(View view) {
        //Toast.makeText(Session3Activity.this, "Clicked1", Toast.LENGTH_SHORT).show();
        Intent explicitIntent = new Intent(Session3Activity.this, Session3bActivity.class);

        Bundle b = new Bundle();
        b.putString("Name", "Dave");

        explicitIntent.putExtras(b);

        startActivity(explicitIntent);
    }
}
