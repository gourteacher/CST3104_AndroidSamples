package com.cst3104.samples;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> elements = new ArrayList<>(  );


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
            elements.add( "This is row " + elements.size() );
            myAdapter.notifyDataSetChanged();
            Log.i(TAG, "addButton");
        });

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                elements.remove(i);
                myAdapter.notifyDataSetChanged();
            }
        });

    }
}

