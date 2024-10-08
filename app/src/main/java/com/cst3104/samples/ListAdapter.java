package com.cst3104.samples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    ArrayList<String> elements;
    LayoutInflater inflater;

    ListAdapter(Context ctx, ArrayList<String> elements) {
        this.elements = elements;
        this.inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() { return elements.size();}

    public Object getItem(int position) { return "This is row " + position; }

    public long getItemId(int position) { return position; }

    public View getView(int position, View old, ViewGroup parent)
    {

        //make a new row:
        View newView = inflater.inflate(R.layout.row_layout, parent, false);

        //set what the text should be for this row:
        TextView tView = newView.findViewById(R.id.textGoesHere);
        tView.setText( getItem(position).toString() );

        //return it to be put in the table
        return newView;
    }
}