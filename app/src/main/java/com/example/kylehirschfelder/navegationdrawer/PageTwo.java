package com.example.kylehirschfelder.navegationdrawer;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class PageTwo extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinToilets, spinToiletUser;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_two);

        spinToilets = (Spinner) findViewById(R.id.spinToilets);
        spinToiletUser = (Spinner) findViewById(R.id.spinToiletUsers);

        ArrayAdapter adapterToilets = ArrayAdapter.createFromResource(this, R.array.toilets, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapterToiletUser = ArrayAdapter.createFromResource(this, R.array.does_everyone_use_toilet, android.R.layout.simple_spinner_dropdown_item);

        spinToiletUser.setAdapter(adapterToiletUser);
        spinToilets.setAdapter(adapterToilets);


        /*

        Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String newDate = df.format(c.getTime());

                pbus = "I hope this works";
                caste = "Testing binary for walls";
                abus1 = " ";
                abus2 = " ";
                abus3 = " ";

                farmdrya = 1;
                farmdryg = 0;
                farmweta = 0;
                farmwetg = 0;

                wall_a = "1";
                wall_d = "8";
                wall_e = "16";
                wall_b = "0";
                wall_c = "0";

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
                familyid = 103;

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

                NameValuePairs.add(new BasicNameValuePair("wall_a", (wall_a)));
                NameValuePairs.add(new BasicNameValuePair("wall_b", (wall_b)));
                NameValuePairs.add(new BasicNameValuePair("wall_c", (wall_c)));
                NameValuePairs.add(new BasicNameValuePair("wall_d", (wall_d)));
                NameValuePairs.add(new BasicNameValuePair("wall_e", (wall_e)));

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
                    Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
                    Log.w(NameValuePairs.toString(), "Here");

                } catch (ClientProtocolException e) {
                    Log.e("ClientProtocol", "log_tag");
                    e.printStackTrace();
                } catch (IOException e) {
                    Log.e("log_tag", "IOException");
                    e.printStackTrace();
                }








         */

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
