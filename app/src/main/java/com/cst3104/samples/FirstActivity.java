package com.cst3104.samples;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById( R.id.startId);

        TextView tv = findViewById(R.id.textViewId);

        start.setOnClickListener(view -> {
            int i = 0;
            while (i <= 20) {
                try {
                    Thread.sleep(1000);
                    i++;
                }
                catch (Exception e) {
                    Log.e(TAG, "Error while sleeping");
                }
            }
            tv.setText("Button Pressed");
        });
    }
}

