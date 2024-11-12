package com.cst3104.samples;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.third_id);

        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.home_id) {
                startActivity(new Intent(getApplicationContext(), FirstActivity.class));
                return true;
            } else if (item.getItemId() == R.id.second_id) {
                startActivity(new Intent(getApplicationContext(), SecondActivity.class));
                return true;
            } else
                return item.getItemId() == R.id.third_id;
        });
    }
}