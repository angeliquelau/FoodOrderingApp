package com.example.foodorderingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.foodorderingapp.ResDBSchema.RestaurantTable;

import java.lang.reflect.Array;
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

    /*This return method is not efficient, use a static ArrayList<String> restaurant,
    ArrayList<String> food name would be better
    https://www.youtube.com/watch?v=VQKq9RHMS_0&t=209s
    */

    //return restaurants food
    public ArrayList<String> getResFood(String restaurant)
    {
        ArrayList<String> resFood = new ArrayList<>();

        Cursor cursor = db.rawQuery("select "+ RestaurantTable.Cols.R_FOOD + " from " +
                        RestaurantTable.NAME + " where " + RestaurantTable.Cols.R_NAME + "= ? "
                ,  new String[] {restaurant});
        ResDBCursor resDBCursor = new ResDBCursor(cursor);

        try{
            cursor.moveToFirst(); //move cursor to the first data in the database
            //while not at the end of the database, loop to add the data into the array list
            while(!cursor.isAfterLast()){
                resFood.add(resDBCursor.getFoodName());
                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }

        return resFood;

    }

    //return restaurants food desc
    public ArrayList<String> getResFoodDesc(String restaurant)
    {
        ArrayList<String> resFoodDesc = new ArrayList<>();

        Cursor cursor = db.rawQuery("select "+ RestaurantTable.Cols.R_FOODDESC + " from " +
                        RestaurantTable.NAME + " where " + RestaurantTable.Cols.R_NAME + " = ? ",
                new String[] {restaurant});
        ResDBCursor resDBCursor = new ResDBCursor(cursor);

        try{
            cursor.moveToFirst(); //move cursor to the first data in the database
            //while not at the end of the database, loop to add the data into the array list
            while(!cursor.isAfterLast()){
                resFoodDesc.add(resDBCursor.getFoodDesc());
                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }

        return resFoodDesc;

    }

    //return restaurants food price
    public ArrayList<Integer> getResFoodPrice(String restaurant)
    {
        ArrayList<Integer> resFoodPrice = new ArrayList<>();

        Cursor cursor = db.rawQuery("select "+ RestaurantTable.Cols.R_FOODPRICE + " from " +
                        RestaurantTable.NAME + " where " + RestaurantTable.Cols.R_NAME + " = ? "
                ,  new String[] {restaurant});
        ResDBCursor resDBCursor = new ResDBCursor(cursor);

        try{
            cursor.moveToFirst(); //move cursor to the first data in the database
            //while not at the end of the database, loop to add the data into the array list
            while(!cursor.isAfterLast()){
                resFoodPrice.add(resDBCursor.getFoodPrice());
                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }

        return resFoodPrice;

    }

    public ArrayList<String> getResName()
    {
        ArrayList<String> resName = new ArrayList<>();
        //display unique restaurants name
        Cursor cursor = db.rawQuery("select distinct "+ RestaurantTable.Cols.R_NAME + " from " + RestaurantTable.NAME,  null);
        ResDBCursor resDBCursor = new ResDBCursor(cursor);

        try{
            cursor.moveToFirst(); //move cursor to the first data in the database
            //while not at the end of the database, loop to add the data into the array list
            while(!cursor.isAfterLast()){
                resName.add(resDBCursor.getRestaurantName());
                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }

        return resName;

    }

    public ArrayList<Restaurant> getAlLRestaurant(){
        ArrayList<Restaurant> resList = new ArrayList<>();
        Cursor cursor = db.query(RestaurantTable.NAME, null, null, null, null, null, null);
        ResDBCursor resDBCursor = new ResDBCursor(cursor);

        try{
            cursor.moveToFirst(); //move cursor to the first data in the database
            //while not at the end of the database, loop to add the data into the array list
            while(!cursor.isAfterLast()){
                resList.add(resDBCursor.getRestaurant());
                cursor.moveToNext();
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

        cursor.close();

        return exist;
    }
}
