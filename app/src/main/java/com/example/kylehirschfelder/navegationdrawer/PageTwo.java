package com.example.kylehirschfelder.navegationdrawer;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
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

public class PageTwo extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinToilets, spinToiletUser, separate_kitchenSpinner;

    Boolean cement, mangalore, normal_tiles, tin, grass, other_roof,
            light, gas, coal, wood, other_cooking,
            well, tap, lake, river, canal, handpump;

    CheckBox cementBox, mangaloreBox, normal_tilesBox, tinBox,
            grassBox, other_roofBox, lightBox, gasBox, coalBox,
            woodBox, other_cookingBox, wellBox, tapBox, lakeBox,
            riverBox, canalBox, handpumpBox;

    String isCement, isMangalore, isNormal_tiles, isTin, isGrass,
            isOther_roof, isLight, isGas, isCoal, isWood, isOther_cooking,
            isWell, isTap, isLake, isRiver, isCanal, isHandpump, isToilet,
            isToiletUser, isKitchen, isElec, isHouse_owner, isReligion,
            wall_a, wall_b, wall_c, wall_d, wall_e, caste, pbus, abus1,
            abus2, abus3, isFam;

    Button submit;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        Bundle data = getIntent().getExtras();
        setContentView(R.layout.page_two);

        submit = (Button) findViewById(R.id.submitBtn);

        cementBox = (CheckBox) findViewById(R.id.cementCheck);
        mangaloreBox = (CheckBox) findViewById(R.id.mangaloreCheck);
        normal_tilesBox = (CheckBox) findViewById(R.id.normalCheck);
        tinBox = (CheckBox) findViewById(R.id.tinCheck);
        grassBox = (CheckBox) findViewById(R.id.grassCheck);
        other_roofBox = (CheckBox) findViewById(R.id.other_roofCheck);
        lightBox = (CheckBox) findViewById(R.id.lightCheck);
        gasBox = (CheckBox) findViewById(R.id.gasCheck);
        coalBox = (CheckBox) findViewById(R.id.coalCheck);
        woodBox = (CheckBox) findViewById(R.id.woodCheck);
        other_cookingBox = (CheckBox) findViewById(R.id.others_cookingCheck);
        wellBox = (CheckBox) findViewById(R.id.wellCheck);
        cementBox = (CheckBox) findViewById(R.id.cementCheck);
        tapBox = (CheckBox) findViewById(R.id.tapCheck);
        lakeBox = (CheckBox) findViewById(R.id.lakeCheck);
        riverBox = (CheckBox) findViewById(R.id.riverCheck);
        canalBox = (CheckBox) findViewById(R.id.canalCheck);
        handpumpBox = (CheckBox) findViewById(R.id.handpumpCheck);

        wall_a = data.getString("wall_a");
        wall_b = data.getString("wall_b");
        wall_c = data.getString("wall_c");
        wall_d = data.getString("wall_d");
        wall_e = data.getString("wall_e");
        caste = data.getString("caste");
        pbus = data.getString("p_business");
        abus1 = data.getString("a_bus_1");
        abus2 = data.getString("a_bus_2");
        abus3 = data.getString("a_bus_3");
        isElec = data.getString("electricity");
        isReligion = data.getString("religion");
        isHouse_owner = data.getString("house_owner");
        isFam = data.getString("fam");

        spinToilets = (Spinner) findViewById(R.id.spinToilets);
        spinToiletUser = (Spinner) findViewById(R.id.spinToiletUsers);
        separate_kitchenSpinner = (Spinner) findViewById(R.id.spinSeparateKitchen);

        ArrayAdapter adapterToilets = ArrayAdapter.createFromResource(this, R.array.toilets, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterToiletUser = ArrayAdapter.createFromResource(this, R.array.does_everyone_use_toilet, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterKitchen = ArrayAdapter.createFromResource(this, R.array.seperate_room_for_kitchen, android.R.layout.simple_spinner_dropdown_item);

        spinToiletUser.setAdapter(adapterToiletUser);
        spinToilets.setAdapter(adapterToilets);
        separate_kitchenSpinner.setAdapter(adapterKitchen);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cement = cementBox.isChecked();
                mangalore = mangaloreBox.isChecked();
                normal_tiles = normal_tilesBox.isChecked();
                tin = tinBox.isChecked();
                grass = grassBox.isChecked();
                other_roof = other_cookingBox.isChecked();
                light = lightBox.isChecked();
                gas = gasBox.isChecked();
                coal = coalBox.isChecked();
                wood = woodBox.isChecked();
                other_cooking = other_cookingBox.isChecked();
                well = wellBox.isChecked();
                tap = tapBox.isChecked();
                lake = lakeBox.isChecked();
                river = riverBox.isChecked();
                canal = canalBox.isChecked();
                handpump = handpumpBox.isChecked();

                if(cement) isCement = "1";
                    else isCement = "0";
                if(mangalore) isMangalore = "2";
                    else isMangalore = "0";
                if(normal_tiles) isNormal_tiles = "4";
                    else isNormal_tiles = "0";
                if(tin) isTin = "8";
                    else isTin = "0";
                if(grass) isGrass = "16";
                    else isGrass = "0";
                if(other_roof) isOther_roof = "32";
                    else isOther_roof = "0";


                if(light) isLight = "1";
                    else isLight = "0";
                if(gas) isGas = "2";
                    else isGas = "0";
                if(coal) isCoal = "4";
                    else isCoal = "0";
                if(wood) isWood = "8";
                    else isWood = "0";
                if(other_cooking) isOther_cooking = "16";
                    else isOther_cooking = "0";


                if(well) isWell = "1";
                    else isWell = "0";
                if(tap) isTap = "4";
                    else isTap = "0";
                if(lake) isLake = "8";
                    else isLake = "0";
                if(river) isRiver = "16";
                    else isRiver = "0";
                if(canal) isCanal = "32";
                    else isCanal = "0";
                if(handpump) isHandpump = "2";
                    else isHandpump = "0";

                isToilet = spinToilets.getSelectedItem().toString();
                isToiletUser = spinToiletUser.getSelectedItem().toString();
                isKitchen = separate_kitchenSpinner.getSelectedItem().toString();

                switch(isToilet){
                    case "Yes": isToilet = "1";
                        break;
                    case "No": isToilet = "0";
                        break;
                }
                switch(isToiletUser){
                    case "Yes": isToiletUser = "1";
                        break;
                    case "No": isToiletUser = "0";
                        break;
                }
                switch(isKitchen){
                    case "Yes": isKitchen = "1";
                        break;
                    case "No": isKitchen = "0";
                        break;
                }
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String newDate = df.format(c.getTime());

                InputStream is;
                List<NameValuePair> NameValuePairs = new ArrayList<NameValuePair>();

                NameValuePairs.add(new BasicNameValuePair("family_id", isFam));
                NameValuePairs.add(new BasicNameValuePair("caste", caste));
                NameValuePairs.add(new BasicNameValuePair("religion", isReligion));
                NameValuePairs.add(new BasicNameValuePair("p_business", pbus));
                NameValuePairs.add(new BasicNameValuePair("a_business_1", abus1));
                NameValuePairs.add(new BasicNameValuePair("a_business_2", abus2));
                NameValuePairs.add(new BasicNameValuePair("a_business_3", abus3));
                NameValuePairs.add(new BasicNameValuePair("wall_a", wall_a));
                NameValuePairs.add(new BasicNameValuePair("wall_b", wall_b));
                NameValuePairs.add(new BasicNameValuePair("wall_c", wall_c));
                NameValuePairs.add(new BasicNameValuePair("wall_d", wall_d));
                NameValuePairs.add(new BasicNameValuePair("wall_e", wall_e));
                NameValuePairs.add(new BasicNameValuePair("roof_a", isCement));
                NameValuePairs.add(new BasicNameValuePair("roof_b", isMangalore));
                NameValuePairs.add(new BasicNameValuePair("roof_c", isNormal_tiles));
                NameValuePairs.add(new BasicNameValuePair("roof_d", isTin));
                NameValuePairs.add(new BasicNameValuePair("roof_e", isGrass));
                NameValuePairs.add(new BasicNameValuePair("roof_f", isOther_roof));
                NameValuePairs.add(new BasicNameValuePair("electricity", isElec));
                NameValuePairs.add(new BasicNameValuePair("house_owner", isHouse_owner));
                NameValuePairs.add(new BasicNameValuePair("toilet", isToilet));
                NameValuePairs.add(new BasicNameValuePair("toilet_use", isToiletUser));
                NameValuePairs.add(new BasicNameValuePair("cook_a", isLight));
                NameValuePairs.add(new BasicNameValuePair("cook_b", isGas));
                NameValuePairs.add(new BasicNameValuePair("cook_c", isCoal));
                NameValuePairs.add(new BasicNameValuePair("cook_d", isWood));
                NameValuePairs.add(new BasicNameValuePair("cook_e", isOther_cooking));
                NameValuePairs.add(new BasicNameValuePair("kitchen", isKitchen));
                NameValuePairs.add(new BasicNameValuePair("water_a", isWell));
                NameValuePairs.add(new BasicNameValuePair("water_b", isHandpump));
                NameValuePairs.add(new BasicNameValuePair("water_c", isTap));
                NameValuePairs.add(new BasicNameValuePair("water_d", isLake));
                NameValuePairs.add(new BasicNameValuePair("water_e", isRiver));
                NameValuePairs.add(new BasicNameValuePair("water_f", isCanal));
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
                    Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page_two, menu);
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