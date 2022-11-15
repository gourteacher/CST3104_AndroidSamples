package com.cst3104.samples;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.second_id);

        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(item ->
                {
                    switch (item.getItemId()) {
                        case R.id.home_id:
                            startActivity(new Intent(getApplicationContext(), FirstActivity.class));
                            return true;

                        case R.id.second_id:
                            return true;

                        case R.id.third_id:
                            startActivity(new Intent(getApplicationContext(), ThirdActivity.class));
                            return true;

                    }
                return false;
                }
        );

    }
}