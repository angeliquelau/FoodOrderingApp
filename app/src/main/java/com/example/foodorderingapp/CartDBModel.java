package com.example.foodorderingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.foodorderingapp.CartDBSchema.CartTable;

import java.util.ArrayList;

public class CartDBModel {
    SQLiteDatabase db;
    public void load(Context context) { this.db = new CartDBHelper(context).getWritableDatabase(); }

    public void addToCart(Cart c){
        ContentValues cv = new ContentValues();
        cv.put(CartTable.Cols.C_USERNAME, c.getUsername());
        cv.put(CartTable.Cols.C_NAME, c.getFoodName());
        cv.put(CartTable.Cols.C_PRICE, c.getFoodPrice());
        cv.put(CartTable.Cols.C_QUANTITY, c.getQuantity());
        db.insert(CartTable.NAME, null, cv); //add food item to cart database
    }

    public void deleteCartItem(String foodName)
    {
        db.delete(CartTable.NAME, CartTable.Cols.C_NAME + "= ?", new String[] {foodName});
    }

    public ArrayList<String> getFoodName(String username)
    {
        ArrayList<String> foodName = new ArrayList<>();
        Cursor cursor = db.rawQuery("select " + CartTable.Cols.C_NAME + " from "
                + CartTable.NAME + " where " + CartTable.Cols.C_USERNAME +
                " = ? ", new String[] {username});
        Log.d("Username", "Cursor = " + cursor);
        Log.d("Username", "Username = " + username);
        CartDBCursor cartDBCursor = new CartDBCursor(cursor);

        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                foodName.add(cartDBCursor.getFoodName());
                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return foodName;
    }


    public ArrayList<Integer> getFoodPrice(String username)
    {
        ArrayList<Integer> foodPrice = new ArrayList<>();
        Cursor cursor = db.rawQuery("select " + CartTable.Cols.C_PRICE + " from "
                + CartTable.NAME + " where " + CartTable.Cols.C_USERNAME +
                "= ? ", new String[] {username});
        CartDBCursor cartDBCursor = new CartDBCursor(cursor);

        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                foodPrice.add(cartDBCursor.getFoodPrice());
                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return foodPrice;
    }

    public int getFoodQuantity(String foodName) {
        int value = 0;
        Cursor cursor = db.rawQuery("select " + CartTable.Cols.C_QUANTITY + " from "
                + CartTable.NAME + " where " + CartTable.Cols.C_NAME  +
                "= ? ", new String[] {foodName});
        CartDBCursor cartDBCursor = new CartDBCursor(cursor);

        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                value = cartDBCursor.getFoodQuantity();
                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return value;
    }

    public boolean foodExist(String foodName)
    {
        boolean exist = false;
        Cursor cursor = db.rawQuery("select * from " + CartTable.NAME + " where "
                + CartTable.Cols.C_NAME + " = ? ", new String[] {foodName});

        if(cursor.getCount() > 0)
        {
            exist = true;
        }
        cursor.close();

        return exist;
    }

    public void updateFoodQuantity(String foodName, int quantity) {
        db.rawQuery("update " + CartTable.NAME + " set " + CartTable.Cols.C_QUANTITY +  "= ? " +  " where " +
                CartTable.Cols.C_NAME + " =? " +
                "= ? ", new String[] {String.valueOf(quantity), foodName});
    }
}
