package com.geewhizstuff.hra55;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String projectToken = "889f8ea7b0077cf3ef1e0338e9914873"; // e.g.: "1ef7e30d2a58d27f4b90c42e31d6d7ad"
        MixpanelAPI mixpanel = MixpanelAPI.getInstance(this, projectToken);
        mixpanel.track("sapan", null);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    
    public void sendAnswer(View v){
        EditText answerView = (EditText) findViewById(R.id.editTextAnswer);
        TextView questionView = (TextView) findViewById(R.id.textViewQuestion);
        String question = questionView.getText().toString();
        String answer = answerView.getText().toString();

        /*URL url = null;
        try {
            url = new URL("http://hra55-1108.appspot.com/command");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpsURLConnection conn = null;
        try {
            conn = (HttpsURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            conn.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        ContentValues values = new ContentValues();
        values.put("action", "answer");
        values.put("q", question);
        values.put("a", answer);

        Base64.OutputStream os = null;
        try {
            os = (Base64.OutputStream) conn.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            writer.write(String.valueOf(values));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer.flush();
            writer.close();
            os.close();
            conn.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        */

        try {
            JSONObject prop = new JSONObject();
            prop.put("action","answer");
            prop.put("q",question);
            prop.put("a",answer);
            mixpanel.track("answer",prop);

        } catch (JSONException e){
            Log.e("sendAnswer", "Unable to add properties to JSSONObject");
        }



    }
}
}
