package com.cst3104.samples;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import com.cst3104.samples.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.computeButton.setOnClickListener(c -> {
            String userInput = binding.userInputId.getText().toString();

            binding.resultTv.setText(userInput);
        });
    }


}

