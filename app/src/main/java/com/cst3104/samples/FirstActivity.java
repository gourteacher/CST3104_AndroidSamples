package com.cst3104.samples;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

//This makes it a page in your application
public class FirstActivity extends AppCompatActivity {
    //use them anywhere in the class:
    private MyAdapter theAdapter;
    private ArrayList<Message> messages;

    //need onCreate:
    @Override
    public void onCreate(Bundle p){
        super.onCreate(p);

        //load XML:
        setContentView(R.layout.activity_main);

        Button submit = findViewById(R.id.submitButton);
        EditText edit = findViewById(R.id.editText);
        ListView lView = findViewById(R.id.myListView);

        messages = new ArrayList<>();
        theAdapter = new MyAdapter();
        lView.setAdapter( theAdapter ) ;

        submit.setOnClickListener( click ->{
            String whatIsTyped = edit.getText().toString();
            Date timeNow = new Date(); //when was this code run

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());

            String currentDateandTime = sdf.format( timeNow ); //convert date to String

            //adding a new message to our history if not empty
            if ( !whatIsTyped.isEmpty()) {
                messages.add(new Message(whatIsTyped, currentDateandTime));

                edit.setText("");//clear the text

                //notify that new data was added at a row:
                theAdapter.notifyDataSetChanged();
            }
        });

    }

    public class MyAdapter extends BaseAdapter {

        public int getCount() { return messages.size();}

        public Object getItem(int position) { return "This is row " + position; }

        public long getItemId(int position) { return position; }

        public View getView(int position, View old, ViewGroup parent)
        {
            LayoutInflater inflater = getLayoutInflater();

            //make a new row:
            View newView = inflater.inflate(R.layout.sent_message, parent, false);

            // What message object is at position:
            Message thisRow = messages.get(position);

            //set what the text should be for this row:
            TextView msgView = newView.findViewById(R.id.message);
            msgView.setText( thisRow.getMessageTyped() );

            TextView timeView = newView.findViewById(R.id.time);
            timeView.setText( thisRow.getTimeSent() );

            //return it to be put in the table
            return newView;
        }
    }

    public class Message{
        String messageTyped;
        String timeSent;

        public Message(String messageTyped, String timeSent) {
            this.messageTyped = messageTyped;
            this.timeSent = timeSent;
        }

        public String getMessageTyped() {
            return messageTyped;
        }

        public String getTimeSent() {
            return timeSent;
        }
    }

}
