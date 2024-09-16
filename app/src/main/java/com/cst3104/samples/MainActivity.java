package com.cst3104.samples;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override  
    //this is our starting point

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //calls parent onCreate()
        setContentView( R.layout.activity_main ); //loads XML on screen

        CheckBox cb =  findViewById(R.id.check);

        RadioButton radio = findViewById(R.id.radio);
        SwitchCompat sw = findViewById(R.id.sw);

        sw.setOnCheckedChangeListener( ( btn, onOrOff) -> {
            radio.setChecked(onOrOff);

            Snackbar. make(sw, R.string.clicked_on_switch, Snackbar.LENGTH_LONG).show();
        });


        cb.setOnCheckedChangeListener( ( b, c) -> {
            Toast.makeText(MainActivity.this, R.string.clicked_on_checkbox, Toast.LENGTH_SHORT).show();
            radio.setChecked(c);
        });

    }
}