package com.example.kylehirschfelder.navegationdrawer;

import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

public class Form1 extends Fragment {

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        myView = inflater.inflate(R.layout.test_push, container,false);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //formButton = (Button) myView.findViewById(R.id.formButton);

        //Declaring all the spinners and linking to their IDs
        religionSpinner = (Spinner) myView.findViewById(R.id.spinReligion);
        electricitySpinner = (Spinner) myView.findViewById(R.id.spinElec);
        house_ownershipSpinner = (Spinner) myView.findViewById(R.id.spinHouseOwner);
        toiletsSpinner = (Spinner) myView.findViewById(R.id.spinToilets);
        toilet_usersSpinner = (Spinner) myView.findViewById(R.id.spinToiletUsers);
        separate_kitchenSpinner = (Spinner) myView.findViewById(R.id.spinSeparateKitchen);
        waterSpinner = (Spinner) myView.findViewById(R.id.spinWater);

        ArrayAdapter adapterRel = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.religion, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterElec = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.electricity, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterHouseOwner = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.house_ownership, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterToilet = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.toilets, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterToiletUsers = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.does_everyone_use_toilet, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterKitchen = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.seperate_room_for_kitchen, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterWater = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.drinking_water, android.R.layout.simple_spinner_dropdown_item);

        religionSpinner.setAdapter(adapterRel);
        electricitySpinner.setAdapter(adapterElec);
        house_ownershipSpinner.setAdapter(adapterHouseOwner);
        toiletsSpinner.setAdapter(adapterToilet);
        toilet_usersSpinner.setAdapter(adapterToiletUsers);
        separate_kitchenSpinner.setAdapter(adapterKitchen);
        waterSpinner.setAdapter(adapterWater);


        formButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String newDate = df.format(c.getTime());

                pbus = "debugging";
                caste = "STILL MOBBIN  I THINK";
                abus1 = " ";
                abus2 = " ";
                abus3 = " ";

                farmdrya = 1;
                farmdryg = 0;
                farmweta = 0;
                farmwetg = 0;
                wall = 1;
                roof = 1;
                electricity = 1;
                houseowner = 1;
                animal = 1;
                oldhouseid = 11;
                oldfamily = 1;
                toilet = 0;
                oldfamily = 1;
                toiletuse = 1;
                toilet = 0;
                cook = 1;
                kitchen = 1;
                water = 1;
                thing = 1;
                religion = 1;
                familyid = 35;

                InputStream is;
                List<NameValuePair> NameValuePairs = new ArrayList<NameValuePair>();
                NameValuePairs.add(new BasicNameValuePair("family_id", Integer.toString(familyid)));
                NameValuePairs.add(new BasicNameValuePair("caste", caste));
                NameValuePairs.add(new BasicNameValuePair("religion", Integer.toString(religion)));
                NameValuePairs.add(new BasicNameValuePair("p_business", pbus));
                NameValuePairs.add(new BasicNameValuePair("a_business_1", abus1));
                NameValuePairs.add(new BasicNameValuePair("a_business_2", abus2));
                NameValuePairs.add(new BasicNameValuePair("a_business_3", abus3));
                NameValuePairs.add(new BasicNameValuePair("farm_dry_a", Integer.toString(farmdrya)));
                NameValuePairs.add(new BasicNameValuePair("farm_dry_g", Integer.toString(farmdryg)));
                NameValuePairs.add(new BasicNameValuePair("farm_wet_a", Integer.toString(farmweta)));
                NameValuePairs.add(new BasicNameValuePair("farm_wet_g", Integer.toString(farmwetg)));
                NameValuePairs.add(new BasicNameValuePair("wall", Integer.toString(wall)));
                NameValuePairs.add(new BasicNameValuePair("roof", Integer.toString(roof)));
                NameValuePairs.add(new BasicNameValuePair("electricity", Integer.toString(electricity)));
                NameValuePairs.add(new BasicNameValuePair("house_owner", Integer.toString(houseowner)));
                NameValuePairs.add(new BasicNameValuePair("toilet", Integer.toString(toilet)));
                NameValuePairs.add(new BasicNameValuePair("toilet_use", Integer.toString(toiletuse)));
                NameValuePairs.add(new BasicNameValuePair("cook", Integer.toString(cook)));
                NameValuePairs.add(new BasicNameValuePair("kitchen", Integer.toString(kitchen)));
                NameValuePairs.add(new BasicNameValuePair("water", Integer.toString(water)));
                NameValuePairs.add(new BasicNameValuePair("thing", Integer.toString(thing)));
                NameValuePairs.add(new BasicNameValuePair("animal", Integer.toString(animal)));
                NameValuePairs.add(new BasicNameValuePair("old_house_id", Integer.toString(oldhouseid)));
                NameValuePairs.add(new BasicNameValuePair("old_family_id", Integer.toString(oldfamily)));
                NameValuePairs.add(new BasicNameValuePair("date", newDate));

                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://45.55.84.23/census/submit");
                    httpPost.setEntity(new UrlEncodedFormEntity(NameValuePairs));
                    HttpResponse response = httpClient.execute(httpPost);
                    HttpEntity entity = response.getEntity();
                    is = entity.getContent();

                    //informs the user that their bug was submitted successfully
                    String msg = "Your form has been submitted";
                    Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
                    Log.w(NameValuePairs.toString(), "Here");

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

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_form1, menu);
        return true;
    }
*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableI fStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
