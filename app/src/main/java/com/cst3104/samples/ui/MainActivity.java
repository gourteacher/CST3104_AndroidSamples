package com.cst3104.samples.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.cst3104.samples.R;
import com.cst3104.samples.data.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new ViewModelProvider(this).get(MainViewModel.class);

        EditText editText = findViewById(R.id.input);
        TextView result = findViewById(R.id.result);
        Button compute = findViewById(R.id.compute);
        result.setText(model.getResultString() );

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setResultString(editText.getText().toString());
                result.setText(model.getResultString());
            }
        });

    }
}