package com.example.kylehirschfelder.navegationdrawer;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class listViewDB extends AppCompatActivity {


    private static final int EDIT = 0, DELETE = 1;
    ListView lv;
    DatabaseHandler db = new DatabaseHandler(this);
    List<Census> censusList = new ArrayList<Census>();
    ArrayAdapter<Census> censusAdapter;
    int longClickItemIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_db);
        lv = (ListView) findViewById(R.id.dblistView);
        List<Census> addablePatients = db.getAllCensus();
        int censusCount = addablePatients.size();

        for(int i = 0; i < censusCount; i++){
           censusList.add(addablePatients.get(i));
        }

        if(db.getCensusCount() != 0){
            censusList.addAll(db.getAllCensus());
        }
        populateList();

        registerForContextMenu(lv);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                longClickItemIndex = position;
                return false;
            }
        });
    }

    public void populateList(){
        censusAdapter = new CensusListAdapter();
        lv.setAdapter(censusAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view_db, menu);
        return true;
    }


    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo info){
        super.onCreateContextMenu(menu, view, info);
        menu.setHeaderIcon(R.drawable.edit_icon);
        menu.setHeaderTitle("Census Options");
        menu.add(Menu.NONE, EDIT, menu.NONE, "Edit Census");
        menu.add(Menu.NONE, DELETE, menu.NONE, "Delete Census");

    }


    public boolean onContextItemSelected(MenuItem item){
        switch(item.getItemId()){
            case EDIT:
                //TODO: Implement editing a patient
                break;
            case DELETE:

                db.deleteContact(censusList.get(longClickItemIndex));
                censusList.remove(longClickItemIndex);
                censusAdapter.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
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

    private class CensusListAdapter extends ArrayAdapter<Census> {
        public CensusListAdapter(){
            super (listViewDB.this, R.layout.listview_item, censusList);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent){
            if(view == null)
                view = getLayoutInflater().inflate(R.layout.listview_item,parent, false);

            Census currentCensus = censusList.get(position);

            TextView familyid = (TextView) view.findViewById(R.id.editFamId);
            familyid.setText(currentCensus.get_famid_str());

            TextView caste = (TextView) view.findViewById(R.id.editCaste);
            caste.setText(currentCensus.get_caste());

            TextView primbus = (TextView) view.findViewById(R.id.editPrimaryBus);
            primbus.setText(currentCensus.get_pbus());

            TextView abus1 = (TextView) view.findViewById(R.id.editABus1);
            abus1.setText(currentCensus.get_abus1());

            TextView abus2 = (TextView) view.findViewById(R.id.editABus2);
            abus2.setText(currentCensus.get_abus2());

            TextView abus3 = (TextView) view.findViewById(R.id.editABus3);
            abus3.setText(currentCensus.get_abus3());

            TextView walls = (TextView) view.findViewById(R.id.editWalls);
            walls.setText(currentCensus.get_wall());

            TextView religion = (TextView) view.findViewById(R.id.editReligion);
            religion.setText(currentCensus.get_religion());

            TextView houseOwner = (TextView) view.findViewById(R.id.editHouseOwner);
            houseOwner.setText(currentCensus.get_houseowner());

            TextView elec = (TextView) view.findViewById(R.id.editElec);
            elec.setText(currentCensus.get_electricity());

            TextView roof = (TextView) view.findViewById(R.id.editRoof);
            roof.setText(currentCensus.get_roof());

            TextView cooking = (TextView) view.findViewById(R.id.editCooking);
            cooking.setText(currentCensus.get_cook());

            TextView water = (TextView) view.findViewById(R.id.editWater);
            water.setText(currentCensus.get_water());

            TextView toilet = (TextView) view.findViewById(R.id.editToilet);
            toilet.setText(currentCensus.get_toilet());

            TextView toiletUser = (TextView) view.findViewById(R.id.editToiletUsers);
            toiletUser.setText(currentCensus.get_toiletuse());

            TextView kitchen = (TextView) view.findViewById(R.id.editKitchen);
            kitchen.setText(currentCensus.get_kitchen());

            return view;
        }
    }
}
