package com.cst3104.samples;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class FirstActivity extends AppCompatActivity {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private final ArrayList<String> elements = new ArrayList<>(  );
    private ListAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myList = findViewById(R.id.theListView);
        myAdapter = new ListAdapter(getApplicationContext(), elements);
        myList.setAdapter(myAdapter);

        View.OnClickListener undo = view -> {
            elements.remove(elements.size() -1);
            myAdapter.notifyDataSetChanged();
            Snackbar.make(view, R.string.list_removal, Snackbar.LENGTH_LONG)
                    .setAction(R.string.dialog_action, null).show();
        };

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            addListItem();
            Snackbar.make(view, R.string.list_addition,
                            Snackbar.LENGTH_LONG)
                    //.setAction(R.string.dialog_action, null).show();
                    .setAction(R.string.dialog_undo, undo).show();
        });
    }

    private void addListItem() {
        SimpleDateFormat dateformat =
                new SimpleDateFormat(DATE_FORMAT,
                        Locale.US);
        elements.add(dateformat.format(new Date()));
        myAdapter.notifyDataSetChanged();
    }
}

