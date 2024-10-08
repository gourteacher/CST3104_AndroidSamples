package com.cst3104.samples;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private final ArrayList<String> elements = new ArrayList<>(  );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListAdapter myAdapter;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myList = findViewById(R.id.theListView);
        myAdapter = new ListAdapter(getApplicationContext(), elements);
        myList.setAdapter( myAdapter);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener( click -> {
            elements.add(String.valueOf(R.string.row_added + elements.size()));
            myAdapter.notifyDataSetChanged();
            Log.i(TAG, "addButton");
        });
    }
}

