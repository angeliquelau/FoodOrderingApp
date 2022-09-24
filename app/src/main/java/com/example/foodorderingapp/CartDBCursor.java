package com.example.foodorderingapp;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.example.foodorderingapp.CartDBSchema.CartTable;

public class CartDBCursor extends CursorWrapper {
    public CartDBCursor(Cursor cursor) { super(cursor); }

    public Cart getCart(){
        String username = getString(getColumnIndex(CartTable.Cols.C_USERNAME));
        String foodName = getString(getColumnIndex(CartTable.Cols.C_NAME));
        int foodPrice = getInt(getColumnIndex(CartTable.Cols.C_PRICE));
        int quantity = getInt(getColumnIndex(CartTable.Cols.C_QUANTITY));

        return new Cart(username, foodName, foodPrice, quantity);
    }
}
