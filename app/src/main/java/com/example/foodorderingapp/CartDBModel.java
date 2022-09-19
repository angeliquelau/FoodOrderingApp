package com.example.foodorderingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.foodorderingapp.CartDBSchema.CartTable;

import java.util.ArrayList;

public class CartDBModel {
    SQLiteDatabase db;
    public void load(Context context) { this.db = new CartDBHelper(context).getWritableDatabase(); }

    public void addToCart(Cart c){
        ContentValues cv = new ContentValues();
        cv.put(CartTable.Cols.C_USERNAME, c.getUsername());
        cv.put(CartTable.Cols.C_FOODIMAGE, c.getFoodImage());
        cv.put(CartTable.Cols.C_NAME, c.getFoodName());
        cv.put(CartTable.Cols.C_PRICE, c.getFoodPrice());
        cv.put(CartTable.Cols.C_QUANTITY, c.getQuantity());
        db.insert(CartTable.NAME, null, cv); //add food item to cart database
    }

    public void deleteCartItem(Cart cart)
    {
        //get the food name to be deleted
        String[] whereValue = { String.valueOf(cart.getFoodName()) };
        //delete from database
        db.delete(CartTable.NAME, CartTable.Cols.C_NAME + "=?", whereValue);
    }

    public ArrayList<Cart> getAllFromCart(){
        ArrayList<Cart> cList = new ArrayList<>();
        Cursor cursor = db.query(CartTable.NAME,null, null, null, null, null, null);
        CartDBCursor cartDBCursor = new CartDBCursor(cursor);

        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                cList.add(cartDBCursor.getCart());
                cursor.moveToNext();
            }
        }
        finally{
            cursor.close();
        }

        return cList;
    }
}
