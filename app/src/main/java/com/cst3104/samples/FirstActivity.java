package com.cst3104.samples;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class FirstActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.home_id);

        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.home_id) {
                return true;
            }
            else if ( item.getItemId() == R.id.second_id ) {
                startActivity(new Intent(getApplicationContext(), SecondActivity.class));
                return true;
            }
            else if (item.getItemId() == R.id.third_id) {
                startActivity(new Intent(getApplicationContext(), ThirdActivity.class));
                return true;
            }
            return false;
        });

    }
}

