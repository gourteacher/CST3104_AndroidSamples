package com.cst3104.samples;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cst3104.samples.FirstActivity;

public class SharedPreferencesExample extends AppCompatActivity {

    public final static String TAG ="SharedPreferencesExample";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_example);

        TextView editText = findViewById(R.id.pref_reserve_name);
        Button saveButton = findViewById(R.id.saveButton);

        SharedPreferences prefs = getSharedPreferences(FirstActivity.PREFERENCES_FILE, MODE_PRIVATE);
        String previous = prefs.getString(FirstActivity.RESERVED_NAME_KEY, getResources().getString(R.string.default_value));
        editText.setText( previous);

        Intent fromPrevious = getIntent();
        //if "USERINPUT" is not found, return null
        String input = fromPrevious.getStringExtra(FirstActivity.USER_INPUT_KEY);
        //if "MONTH" is not found, return 0
        int month = fromPrevious.getIntExtra(FirstActivity.MONTH_KEY, 0);
        //if "OTHERINFO" is not found, return 0.0
        double other = fromPrevious.getDoubleExtra(FirstActivity.OTHER_INFO_KEY, 0.0);

        EditText userInput = findViewById(R.id.pref_user_input);
        if ( !input.isEmpty()) {
            userInput.setText(input);
        }
        TextView tv1 = findViewById(R.id.pref_month);
        tv1.setText(Integer.toString(month));
        TextView tv2 = findViewById(R.id.pref_other_info);
        tv2.setText(Double.toString(other));

        saveButton.setOnClickListener(clk -> {
            SharedPreferences.Editor writer = prefs.edit();
            writer.putString(FirstActivity.RESERVED_NAME_KEY, editText.getText().toString());
            writer.putString(FirstActivity.USER_INPUT_KEY, userInput.getText().toString());
            writer.putInt(FirstActivity.MONTH_KEY, month);
            writer.putFloat(FirstActivity.OTHER_INFO_KEY, (float)other);

            writer.apply(); //save to disk
        });

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener( clk -> finish() ) ;

    }
}