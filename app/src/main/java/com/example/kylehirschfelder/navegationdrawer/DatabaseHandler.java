package com.example.kylehirschfelder.navegationdrawer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "formManager",
    TABLE_CENSUS = "census",
    KEY_CASTE = "caste",
    KEY_PBUS = "p_bus",
    KEY_ABUS1 = "a_bus_1",
    KEY_ABUS2 = "a_bus_2",
    KEY_ABUS3 = "a_bus_3",
    KEY_FARMDRYA = "farm_dry_a",
    KEY_FARMDRYG = "farm_dry_g",
    KEY_FARMWETA = "farm_wet_a",
    KEY_FARMWETG = "farm_wet_g",
    KEY_WALL = "wall",
    KEY_ROOF = "roof",
    KEY_ELECTRICITY = "electricity",
    KEY_HOUSEOWNER = "house_owner",
    KEY_ANIMAL = "animal",
    KEY_OLDHOUSEID = "old_house_id",
    KEY_OLDFAMILY = "old_family_id",
    KEY_TOILETUSE = "toilet_use",
    KEY_TOILET = "toilet",
    KEY_COOK = "cook",
    KEY_KITCHEN = "kitchen",
    KEY_WATER = "water",
    KEY_THING = "thing",
    KEY_DATE = "date",
    KEY_HOUSEID = "house_id",
    KEY_RELIGION = "religion";


    public DatabaseHandler(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS ASSIGNMENTS  "
                + TABLE_CENSUS + "("
                + KEY_HOUSEID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_CASTE + " VARCHAR,"
                + KEY_RELIGION + " INT,"
                + KEY_PBUS + " MEDIUMTEXT,"
                + KEY_ABUS1 + " MEDIUMTEXT,"
                + KEY_ABUS2 + " MEDIUMTEXT,"
                + KEY_ABUS3 + " MEDIUMTEXT,"
                + KEY_FARMDRYA + " INT,"
                + KEY_FARMDRYG + " INT,"
                + KEY_FARMWETA + " INT,"
                + KEY_FARMWETG + " INT,"
                + KEY_WALL + " INT,"
                + KEY_ROOF + " INT,"
                + KEY_ELECTRICITY + " INT,"
                + KEY_HOUSEOWNER + " INT,"
                + KEY_TOILET + " INT,"
                + KEY_TOILETUSE + " INT,"
                + KEY_COOK + " INT,"
                + KEY_KITCHEN + " INT,"
                + KEY_WATER + " INT,"
                + KEY_THING + " INT,"
                + KEY_ANIMAL + " INT,"
                + KEY_OLDHOUSEID + " INT,"
                + KEY_OLDFAMILY + " INT,"
                + KEY_DATE + " INT);");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CENSUS);
        onCreate(db);
    }

    public void createCensus(Census census){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

    }

}
