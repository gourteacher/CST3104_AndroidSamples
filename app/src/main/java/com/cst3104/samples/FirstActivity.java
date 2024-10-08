package com.cst3104.samples;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
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
            elements.add(String.valueOf(R.string.item_added + elements.size()));
            myAdapter.notifyDataSetChanged();
            Log.i(TAG, "addButton");
        });

        myList.setOnItemClickListener((adapterView, view, i, l) -> {
            elements.remove(i);
            myAdapter.notifyDataSetChanged();
        });

        myList.setOnItemLongClickListener( (p, b, pos, id) -> {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle(R.string.dialog_title)

                    //What is the message:
                    .setMessage(R.string.dialog_message)

                    //what the Yes button does:
                    .setPositiveButton( R.string.dialog_positive, (click, arg) -> {
                        elements.add(getString(R.string.sample_message));
                        myAdapter.notifyDataSetChanged();
                    })
                    //What the No button does:
                    .setNegativeButton(R.string.dialog_negative, (click, arg) -> { })

                    //An optional third button:
                    .setNeutralButton(R.string.dialog_cancel, (click, arg) -> {  })

                    //Show the dialog
                    .create().show();
            return true;
        });


    }
}

