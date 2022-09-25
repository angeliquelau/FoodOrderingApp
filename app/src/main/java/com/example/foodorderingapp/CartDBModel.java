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


    // Return all cart items
    public ArrayList<Cart> getAllCart(){
        ArrayList<Cart> cartList = new ArrayList<>();
        Cursor cursor = db.query(CartTable.NAME, null, null, null, null, null, null);
        CartDBCursor cartDBCursor = new CartDBCursor(cursor);

        try{
            cursor.moveToFirst(); //move cursor to the first data in the database
            //while not at the end of the database, loop to add the data into the array list
            while(!cursor.isAfterLast()){
                cartList.add(cartDBCursor.getCart());
                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return cartList;
    }


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
                " = ? ", new String[] {foodName});
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
                + CartTable.Cols.C_NAME + " = ? " + " AND " + CartTable.Cols.C_QUANTITY + " IS NOT NULL"
                , new String[] {foodName});

        if(cursor.getCount() > 0)
        {
            exist = true;
        }
        cursor.close();

        return exist;
    }

    /*SELECT * FROM TABLE WHERE FOOD = ? AND USERNAME = ?*/

    public void updateCart(Cart c){
        ContentValues cv = new ContentValues();
        cv.put(CartTable.Cols.C_USERNAME, c.getUsername());
        cv.put(CartTable.Cols.C_NAME, c.getFoodName());
        cv.put(CartTable.Cols.C_PRICE, c.getFoodPrice());
        cv.put(CartTable.Cols.C_QUANTITY, c.getQuantity());
        String[] whereValue = { String.valueOf(c.getFoodName()) }; //get the name of the food that the user want to edit
        db.update(CartTable.NAME, cv, CartTable.Cols.C_NAME + " = ? ", whereValue); //update food item that is in cart database
    }

    public void updateFoodQuantity(String username, String foodName, int foodPrice, int quantity) {
        ContentValues cv = new ContentValues();
        cv.put(CartTable.Cols.C_USERNAME, username);
        cv.put(CartTable.Cols.C_NAME, foodName);
        cv.put(CartTable.Cols.C_PRICE, foodPrice);
        cv.put(CartTable.Cols.C_QUANTITY, quantity);
        String [] whereValue = {foodName};
        db.update(CartTable.NAME, cv, CartTable.Cols.C_NAME + " = ? ", whereValue);

    }

    public void updateUsername(String oldUsername, String username)
    {/*
        db.rawQuery("update " + CartTable.NAME + " set " + CartTable.Cols.C_USERNAME +  "= ? "
                        + " where "  + CartTable.Cols.C_USERNAME + " = ? " ,
                new String[] {username, oldUsername});*/

        ContentValues cv = new ContentValues();
        cv.put(CartTable.Cols.C_USERNAME,username);
        String[] whereValue = {oldUsername};
        db.update(CartTable.NAME, cv, CartTable.Cols.C_USERNAME + " = ? ", whereValue);
    }
}
