package com.example.foodorderingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.foodorderingapp.FoodHistoryDBSchema.FoodHistoryTable;

import java.util.ArrayList;

public class FoodHistoryDBModel {
    SQLiteDatabase db;

    public void load(Context context) { this.db = new FoodHistoryDBHelper(context).getWritableDatabase(); }

    public void addFoodHistory(FoodHistory fh){
        ContentValues cv = new ContentValues();
        cv.put(FoodHistoryTable.Cols.FH_USERNAME, fh.getUsername());
        cv.put(FoodHistoryTable.Cols.FH_NAME, fh.getFoodName());
        cv.put(FoodHistoryTable.Cols.FH_PRICE, fh.getFoodPrice());
        db.insert(FoodHistoryTable.NAME, null, cv); //add user's food order history into the database
    }

    public ArrayList<FoodHistory> getAllFoodHistory(){
        ArrayList<FoodHistory> fhList = new ArrayList<>();
        Cursor cursor = db.query(FoodHistoryTable.NAME, null, null, null, null, null, null);
        FoodHistoryDBCursor fhDBCursor = new FoodHistoryDBCursor(cursor);

        try{
            cursor.moveToFirst(); //move cursor to the first data in the database
            //while not at the end of the database, loop to add the data into the array list
            while(!cursor.isAfterLast()){
                fhList.add(fhDBCursor.getFoodHistory());
                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }

        return fhList;
    }
}
