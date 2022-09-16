package com.example.foodorderingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.foodorderingapp.ResDBSchema.RestaurantTable;

import java.util.ArrayList;

public class ResDBModel {
    SQLiteDatabase db;

    public void load(Context context){
        this.db = new ResDBHelper(context).getWritableDatabase();
    }

    public void addRestaurant(Restaurant res){
        ContentValues cv = new ContentValues();
        cv.put(RestaurantTable.Cols.R_NAME, res.getResName());
        cv.put(RestaurantTable.Cols.R_IMAGE, res.getResImage());
        cv.put(RestaurantTable.Cols.R_FOOD, res.getResFoodName());
        cv.put(RestaurantTable.Cols.R_FOODIMAGE, res.getResFoodImage());
        cv.put(RestaurantTable.Cols.R_FOODPRICE, res.getResFoodPrice());
        cv.put(RestaurantTable.Cols.R_FOODDESC, res.getResFoodDesc());

        db.insert(RestaurantTable.NAME, null, cv); //add information into database
    }

    public ArrayList<Restaurant> getAlLRestaurant(){
        ArrayList<Restaurant> resList = new ArrayList<>();
        Cursor cursor = db.query(RestaurantTable.NAME, null, null, null, null, null, null);
        ResDBCursor resDBCursor = new ResDBCursor(cursor);

        try{
            cursor.moveToFirst(); //move cursor to the first data in the database
            //while not at the end of the database, loop to add the data into the array list
            while(!resDBCursor.isAfterLast()){
                resList.add(resDBCursor.getRestaurant());
                resDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return resList;
    }

    public boolean checkDataEntry(String restaurant)
    {
        boolean exist = false;
        Cursor cursor = db.rawQuery("select * from " + ResDBSchema.RestaurantTable.NAME + " where " + RestaurantTable.Cols.R_NAME + " = ? ", new String[] {restaurant});

        if(cursor.getCount() > 0)
        {
            exist = true;
        }

        return exist;
    }
}
