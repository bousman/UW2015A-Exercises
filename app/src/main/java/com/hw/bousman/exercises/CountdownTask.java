package com.hw.bousman.exercises;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;

// 1st: doInBackground parameter
// 2nd: sent to onProgressUpdate
// 3rd: result of doInBackground and sent to onPostExecute
public class CountdownTask extends AsyncTask<Integer, Integer, Void> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(CountdownTask.class.toString(), "onPreExecute");
    }

    @Override
    protected Void doInBackground(Integer... count) {
        for (int i = 0; i < count[0]; i++) {
            //Log.d(CountdownTask.class.toString(), "i="+i);
            publishProgress((int) ((i / (float) count[0]) * 100));
            SystemClock.sleep(100);
            // Escape early if cancel() is called
            if (isCancelled()) {
                break;
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        Log.d(CountdownTask.class.toString(), "onProgressUpdate:" + values[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d(CountdownTask.class.toString(), "onPostExecute");
    }
}
