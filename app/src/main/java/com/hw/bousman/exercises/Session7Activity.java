package com.hw.bousman.exercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;

public class Session7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session7);
    }


    public void onClick(View view) {
        DbHelper db = DbHelper.getInstance(this);

        db.addSession("steve", new Date());

        DBSession[] sessions = db.getSessions();

        DBSession session = sessions[0];
        db.updateSession(session.SessionId, session.Name + "-updated", session.StartDate);

        sessions = db.getSessions();

        db.deleteSession(session.SessionId);

        sessions = db.getSessions();
    }


    public void onClick2(View view) {
        DbHelper db = DbHelper.getInstance(this);
        db.addSession("Brian", new Date());
        db.addSession("Gary", new Date());
        db.addSession("John", new Date());
        db.addSession("Kell", new Date());
        db.addSession("Chad", new Date());
        db.addSession("Tom", new Date());
        db.addSession("Kevin", new Date());
        db.addSession("Rachel", new Date());
        db.addSession("Scott", new Date());
        db.addSession("Phil", new Date());

        DBSession[] sessions = db.getSessions();
        ArrayList<String> dataList = new ArrayList<>();
        for ( DBSession dbData : sessions ) {
            dataList.add( dbData.toString() );
        }
        db.deleteSessions();  // no longer need the data as it went to string array

        Bundle b = new Bundle();
        b.putStringArrayList("database",dataList);
        Intent explicitIntent = new Intent(this, Session7bActivity.class);
        explicitIntent.putExtras(b);
        startActivity(explicitIntent);
    }
}
