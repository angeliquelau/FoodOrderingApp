package com.example.foodorderingapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.foodorderingapp.ResDBSchema.RestaurantTable;

public class ResDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1; //database version 1
    private static final String DATABASE_NAME = "restaurants.db";

    //constructor
    public ResDBHelper(Context context) { super(context, DATABASE_NAME, null, VERSION); }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //creating the database table here with sqlite command
        sqLiteDatabase.execSQL("create table " + RestaurantTable.NAME +
                "(" + RestaurantTable.Cols.R_NAME + " Text, " + RestaurantTable.Cols.R_IMAGE + " Text, " +
                RestaurantTable.Cols.R_FOOD + " Text, " + RestaurantTable.Cols.R_FOODIMAGE + " Text, " +
                RestaurantTable.Cols.R_FOODPRICE + " Text, " + RestaurantTable.Cols.R_FOODDESC + " Text);");
    }

    //we won't be upgrading the database so we leave this empty
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
