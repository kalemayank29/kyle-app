package com.example.kylehirschfelder.navegationdrawer;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
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

public class Form_1 extends ActionBarActivity implements AdapterView.OnItemSelectedListener{

    Button formButton;
    String caste, pbus, abus1, abus2, abus3;
    int farmdrya, farmdryg, farmweta, farmwetg, wall,
            roof, electricity, houseowner, animal, oldhouseid,
            oldfamily, toiletuse, toilet, cook, kitchen, water,
            thing, religion, familyid;
    Spinner religionSpinner, electricitySpinner, house_ownershipSpinner,
            toiletsSpinner, toilet_usersSpinner, separate_kitchenSpinner,
            waterSpinner;
    View myView;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);



        //Declaring all the spinners and linking to their IDs
         religionSpinner = (Spinner) findViewById(R.id.spinReligion);
         electricitySpinner = (Spinner) findViewById(R.id.spinElec);
         house_ownershipSpinner = (Spinner) findViewById(R.id.spinHouseOwner);
         toiletsSpinner = (Spinner) findViewById(R.id.spinToilets);
         toilet_usersSpinner = (Spinner) findViewById(R.id.spinToiletUsers);
         separate_kitchenSpinner = (Spinner) findViewById(R.id.spinSeparateKitchen);
         waterSpinner = (Spinner) findViewById(R.id.spinWater);

        ArrayAdapter adapterRel = ArrayAdapter.createFromResource(this, R.array.religion, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterElec = ArrayAdapter.createFromResource(this, R.array.electricity, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterHouseOwner = ArrayAdapter.createFromResource(this, R.array.house_ownership, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterToilet = ArrayAdapter.createFromResource(this, R.array.toilets, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterToiletUsers = ArrayAdapter.createFromResource(this, R.array.does_everyone_use_toilet, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterKitchen = ArrayAdapter.createFromResource(this, R.array.seperate_room_for_kitchen, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterWater = ArrayAdapter.createFromResource(this, R.array.drinking_water, android.R.layout.simple_spinner_dropdown_item);

        religionSpinner.setAdapter(adapterRel);
        electricitySpinner.setAdapter(adapterElec);
        house_ownershipSpinner.setAdapter(adapterHouseOwner);
        toiletsSpinner.setAdapter(adapterToilet);
        toilet_usersSpinner.setAdapter(adapterToiletUsers);
        separate_kitchenSpinner.setAdapter(adapterKitchen);
        waterSpinner.setAdapter(adapterWater);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form_1, menu);
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
