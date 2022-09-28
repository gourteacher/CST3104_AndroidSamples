package com.cst3104.samples;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    public final static String TAG ="FirstActivity";
    public final static String PREFERENCES_FILE = "MyData";

    public final static String RESERVED_NAME_KEY = "ReservedName";
    public final static String USER_INPUT_KEY = "USERINPUT";
    public final static String MONTH_KEY = "MONTH";
    public final static String OTHER_INFO_KEY = "OTHER INFO";

    @Override     //first called
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //calls parent onCreate()

        setContentView( R.layout.activity_first); //loads XML on screen

        initScreen();
    }

    private void initScreen() {
        SharedPreferences prefs = getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        //Read preferences
        String previous = prefs.getString(RESERVED_NAME_KEY, getResources().getString(R.string.default_value) );
        TextView edit = findViewById(R.id.reserved_name);
        edit.setText(previous);

        //SharedPreferencesExample
        Button btnSharedPrefs = findViewById(R.id.shared_preferences);
        btnSharedPrefs.setOnClickListener( (  click ) ->
        {
            EditText userText = findViewById(R.id.user_input);
            Intent nextPage = new Intent(FirstActivity.this,   SharedPreferencesExample.class  );

            String userTyped = userText.getText().toString();
            nextPage.putExtra(USER_INPUT_KEY, userTyped);

            nextPage.putExtra(MONTH_KEY, 100);
            nextPage.putExtra(OTHER_INFO_KEY, 33.14);

            //Make the transition:
            startActivity( nextPage );
        });
    }

    @Override //screen is visible but not responding
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "In onStart, visible but not responding");

    }

    @Override //screen is visible but not responding
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "In onResume");
    }

    @Override //screen is visible but not responding
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "In onPause");
    }

    @Override //not visible
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "In onStop");
    }

    @Override  //garbage collected
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "In onDestroy");
    }
}