package com.hw.bousman.exercises;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Session8Activity extends AppCompatActivity {
    Button btn_start;
    ProgressBar progressBar;
    TextView txt_percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session8);

        btn_start = (Button) findViewById(R.id.btn_start);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        txt_percentage = (TextView) findViewById(R.id.txt_percentage);
    }


    public void onClick(View view) {
        final TextView textView = (TextView) findViewById(R.id.textView);
        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 10; x++) {
                    SystemClock.sleep(1000);
                    Log.d("main", Integer.toString(x));
                    final int xcount = x;

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(Integer.toString(xcount));
                        }
                    });
                }
            }
        }).start();

    }

    public void onClick2(View view) {
        new CountdownTask().execute(100);
    }


    public void onClick3(View view) {
        btn_start.setEnabled(false);
        new ShowDialogAsyncTask().execute();
    }


    private class ShowDialogAsyncTask extends AsyncTask<Void, Integer, Void> {

        int progress_status;

        @Override
        protected void onPreExecute() {
            // update the UI immediately after the task is executed
            super.onPreExecute();

            Toast.makeText(Session8Activity.this,
                    "Invoke onPreExecute()", Toast.LENGTH_SHORT).show();

            progress_status = 0;
            txt_percentage.setText("downloading 0%");

        }

        @Override
        protected Void doInBackground(Void... params) {

            while (progress_status < 100) {

                progress_status += 2;

                publishProgress(progress_status);
                SystemClock.sleep(100);

            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar.setProgress(values[0]);
            txt_percentage.setText("downloading " + values[0] + "%");

        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            Toast.makeText(Session8Activity.this,
                    "Invoke onPostExecute()", Toast.LENGTH_SHORT).show();

            txt_percentage.setText("download complete");
            btn_start.setEnabled(true);
        }

    }
}
