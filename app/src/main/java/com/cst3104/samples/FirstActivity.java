package com.cst3104.samples;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyHTTPRequest req = new MyHTTPRequest();
        req.execute("https://api.publicapis.org/entries");  //Type 1
    }

    //Type1     Type2   Type3
    private static class MyHTTPRequest extends AsyncTask< String, Integer, String>
    {
        static private final String TAG = "MyHTTPRequest";

        //Type3                Type1
        public String doInBackground(String ... args)
        {
            try {

                //create a URL object of what server to contact:
                URL url = new URL(args[0]);

                //open the connection
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                //wait for data:
                InputStream response = urlConnection.getInputStream();

                //JSON reading:
                //Build the entire string response:
                BufferedReader reader = new BufferedReader(new InputStreamReader(response, StandardCharsets.UTF_8), 8);
                StringBuilder sb = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null)
                {
                    sb.append(line).append("\n");
                }
                String result = sb.toString(); //result is the whole string

                // convert string to JSON
                JSONObject uvReport = new JSONObject(result);

                //get the double associated with "value"
                int numEntries = uvReport.getInt("count");

                publishProgress(25);
                Thread.sleep(1000);
                publishProgress(50);
                Log.i(TAG, "Number of entries: " + numEntries) ;
            }
            catch (Exception e)
            {
                Log.w(TAG, "Error in doInBackground");
            }
            return "Done";
        }

        //Type 2
        public void onProgressUpdate(Integer ... args)
        {
            Log.i(TAG, "onProgressUpdate");
        }

        //Type3
        public void onPostExecute(String fromDoInBackground)
        {
            Log.i(TAG, fromDoInBackground);
        }
    }
}

