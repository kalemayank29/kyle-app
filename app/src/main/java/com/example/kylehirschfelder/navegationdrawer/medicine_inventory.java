package com.example.kylehirschfelder.navegationdrawer;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class medicine_inventory extends AppCompatActivity {


    Button submit;
    EditText editMed, editNoTabs, editMg, editExp, editOpen, editPatientId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_inventory);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        submit = (Button) findViewById(R.id.submit);

        editMed = (EditText) findViewById(R.id.medicine_name);
        editNoTabs = (EditText) findViewById(R.id.no_tab);
        editMg = (EditText) findViewById(R.id.mg_tab);
        editExp = (EditText) findViewById(R.id.expiry);
        editOpen = (EditText) findViewById(R.id.opened);
        editPatientId = (EditText) findViewById(R.id.patient_id);


        // Get a reference to the AutoCompleteTextView in the layout
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.medicine_name);

        // Get the string array
        String[] medicine = getResources().getStringArray(R.array.medicine_array);

        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, medicine);

        textView.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = "" + editMed.getText().toString();
                String tab = "" + editMg.getText().toString();
                String exp_date = "" + editExp.getText().toString();
                String bott_date = "" + editOpen.getText().toString();
                String no_tab = "" + editNoTabs.getText().toString();
                String patient_id = "" + editPatientId.getText().toString();


                InputStream is = null;
                List<NameValuePair> NameValuePairs = new ArrayList<NameValuePair>();
                NameValuePairs.add(new BasicNameValuePair("name", name));
                NameValuePairs.add(new BasicNameValuePair("tab", tab));
                NameValuePairs.add(new BasicNameValuePair("exp_date", exp_date));
                NameValuePairs.add(new BasicNameValuePair("bott_date", bott_date));
                NameValuePairs.add(new BasicNameValuePair("no_tab", no_tab));
                NameValuePairs.add(new BasicNameValuePair("patient_id", patient_id));


                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://45.55.84.23/med/add");
                    httpPost.setEntity(new UrlEncodedFormEntity(NameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);
                    HttpEntity entity = response.getEntity();
                    is = entity.getContent();
                    String msg = "Your medicine has been submitted to the inventory";

                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();


                } catch (ClientProtocolException e) {
                    Log.e("ClientProtocol", "log_tag");
                    e.printStackTrace();
                } catch (IOException e) {
                    Log.e("log_tag", "IOException");
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_medicine_inventory, menu);
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
}
