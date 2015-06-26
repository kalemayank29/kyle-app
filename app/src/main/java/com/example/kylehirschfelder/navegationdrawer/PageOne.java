package com.example.kylehirschfelder.navegationdrawer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

public class PageOne extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    Button formButton;
    String caste, pbus, abus1, abus2, abus3, wall_a,wall_b,wall_c, wall_d, wall_e;

    int farmdrya, farmdryg, farmweta, farmwetg,
            roof, electricity, houseowner, animal, oldhouseid,
            oldfamily, toiletuse, toilet, cook, kitchen, water,
            thing, religion, familyid;
    Spinner religionSpinner, electricitySpinner, house_ownershipSpinner,
            toiletsSpinner, toilet_usersSpinner, separate_kitchenSpinner,
            waterSpinner;

    View myView;

    Button newButton;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_one);

        religionSpinner = (Spinner) findViewById(R.id.spinReligion);
        electricitySpinner = (Spinner) findViewById(R.id.spinElec);
        house_ownershipSpinner = (Spinner) findViewById(R.id.spinHouseOwner);
        separate_kitchenSpinner = (Spinner) findViewById(R.id.spinSeparateKitchen);

        ArrayAdapter adapterRel = ArrayAdapter.createFromResource(this, R.array.religion, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterElec = ArrayAdapter.createFromResource(this, R.array.electricity, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterHouseOwner = ArrayAdapter.createFromResource(this, R.array.house_ownership, android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter adapterKitchen = ArrayAdapter.createFromResource(this, R.array.seperate_room_for_kitchen, android.R.layout.simple_spinner_dropdown_item);

        religionSpinner.setAdapter(adapterRel);
        electricitySpinner.setAdapter(adapterElec);
        house_ownershipSpinner.setAdapter(adapterHouseOwner);
        separate_kitchenSpinner.setAdapter(adapterKitchen);


        newButton = (Button) findViewById(R.id.next);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PageOne.this, PageTwo.class));

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page_one, menu);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
