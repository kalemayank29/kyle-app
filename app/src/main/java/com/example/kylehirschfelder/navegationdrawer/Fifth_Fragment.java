package com.example.kylehirschfelder.navegationdrawer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import android.widget.AdapterView.OnItemSelectedListener;

public class Fifth_Fragment extends Fragment {
    View myView;
    EditText etUser, etBug;
    Button bugButton;
    Spinner etSpinCat, etSpinImport;

    @Override
    @SuppressLint("NewApi")

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //me tood
        myView = inflater.inflate(R.layout.fifth_layout, container, false);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        etUser = (EditText) myView.findViewById(R.id.editName);
        etBug = (EditText) myView.findViewById(R.id.editBug);
        etSpinCat = (Spinner) myView.findViewById(R.id.spinCat);
        etSpinImport = (Spinner) myView.findViewById(R.id.spinImport);
        bugButton = (Button) myView.findViewById(R.id.bugButton);

        ArrayAdapter adapterCat = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.category, android.R.layout.simple_spinner_dropdown_item);
        etSpinCat.setAdapter(adapterCat);
        ArrayAdapter adapterImport = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.importance, android.R.layout.simple_spinner_dropdown_item);
        etSpinImport.setAdapter(adapterImport);

        bugButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String newDate = df.format(c.getTime());

                String user = "" + etUser.getText().toString();
                String bug = "" + etBug.getText().toString();
                String cat = "" + etSpinCat.getSelectedItem().toString();
                String spinImport = "" + etSpinImport.getSelectedItem().toString();
                InputStream is;

                List<NameValuePair> NameValuePairs = new ArrayList<NameValuePair>(1);
                NameValuePairs.add(new BasicNameValuePair("user", user));
                NameValuePairs.add(new BasicNameValuePair("bug", bug));
                NameValuePairs.add(new BasicNameValuePair("category", cat));
                NameValuePairs.add(new BasicNameValuePair("importance", spinImport));
                NameValuePairs.add(new BasicNameValuePair("date", newDate));

                try {
                    //error messages if either field for submitting a bug is left empty
                    if (user.equals("")) {
                        Toast.makeText(getActivity(), "Please enter your name", Toast.LENGTH_LONG).show();
                        return;
                    } else if (bug.equals("")) {
                        Toast.makeText(getActivity(), "Please enter your bug", Toast.LENGTH_LONG).show();
                        return;
                    }
                    //handles the connection to the server via IP address (45.55.84.23).
                    //This routes the NameValuePairs list containing the bug data to the server
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://45.55.84.23/bugs/submit");
                    httpPost.setEntity(new UrlEncodedFormEntity(NameValuePairs));
                    HttpResponse response = httpClient.execute(httpPost);
                    HttpEntity entity = response.getEntity();
                    is = entity.getContent();

                    //informs the user that their bug was submitted successfully
                    String msg = "Your bug has been submitted";
                    Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();

                } catch (ClientProtocolException e) {
                    Log.e("ClientProtocol", "log_tag");
                    e.printStackTrace();
                } catch (IOException e) {
                    Log.e("log_tag", "IOException");
                    e.printStackTrace();
                }
            }
        });
        return myView;
    }
}
