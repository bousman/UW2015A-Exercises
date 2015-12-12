package com.hw.bousman.exercises;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class Session5Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session5);

        //registerForContextMenu();  // for context menus
    }

    private PopupWindow pw;

    public void ClickMe(View v)
    {
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layout = inflater.inflate(R.layout.popup_example, null, false);

        Button closeButton = (Button)layout.findViewById(R.id.close);

        closeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pw.dismiss();
            }
        });

        pw = new PopupWindow(layout,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                true);

        pw.showAtLocation(this.findViewById(R.id.main), Gravity.CENTER, 0, 0);
    }


    public void onDialog(View v)
    {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("Message")
                .setTitle("Title");

        // 3. Add the buttons
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });

        // 4. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();

        dialog.show();
    }


    public void onDialog2(View v) {
        final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.dialog_demo);

        dialog.setTitle("My Dialog title");

        Button okButton = (Button)dialog.findViewById(R.id.dialog_ok);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }



    public void onExercise(View v) {
        final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.dialog_exercise);
        dialog.setTitle("My Dialog title");


        Button okButton = (Button)dialog.findViewById(R.id.dialog_ok);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userv = (EditText) dialog.findViewById(R.id.exer_username);
                String username = userv.getText().toString();
                EditText passv = (EditText) dialog.findViewById(R.id.exer_password);
                String password = passv.getText().toString();
                if (!username.isEmpty() && username.equals("test") && password.equals("password")) {
                    Toast.makeText(Session5Activity.this, "logged in", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });

        Button cancelButton = (Button)dialog.findViewById(R.id.dialog_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }





    static Boolean box1_checked = false;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Toast.makeText(this, "onCreateOptionsMenu", Toast.LENGTH_LONG).show();
        Log.d( "Session5", "onCreateOptionsMenu");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.session5_menus, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("Session5", "onOptionsItemSelected");
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this, "action_search", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_compose:
                Toast.makeText(this, "action_compose", Toast.LENGTH_LONG).show();
                return true;
            case R.id.popup_box1:
            case R.id.popup_box2:
            case R.id.popup_box3:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.session5_popup_menu);
        popup.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Log.d("Session5", "onMenuItemClick");
        switch (item.getItemId()) {
            case R.id.popup_box1:
                if ( item.isChecked() )
                {
                    Log.d("box1","turning off check");
                    item.setChecked(false);
                    box1_checked = false;
                }
                else
                {
                    Log.d("box1","turning on check");
                    item.setChecked(true);
                    box1_checked = true;
                }
                Log.d( "Popup", "box1");
                return true;
            case R.id.popup_box2:
                Log.d( "Popup", "box2");
                return true;
            case R.id.popup_box3:
                Log.d( "Popup", "box3");
                return true;
        }
        return false;
    }

}
