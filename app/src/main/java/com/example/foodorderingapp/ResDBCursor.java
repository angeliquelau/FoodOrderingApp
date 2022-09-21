package com.example.foodorderingapp;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.example.foodorderingapp.ResDBSchema.RestaurantTable;

public class ResDBCursor extends CursorWrapper {

    public ResDBCursor(Cursor cursor) { super(cursor); }

    public Restaurant getRestaurant(){
        String resName = getString(getColumnIndex(RestaurantTable.Cols.R_NAME));
        String resImage = getString(getColumnIndex(RestaurantTable.Cols.R_IMAGE));
        String resFoodName = getString(getColumnIndex(RestaurantTable.Cols.R_FOOD));
        String resFoodImage = getString(getColumnIndex(RestaurantTable.Cols.R_FOODIMAGE));
        int resFoodPrice = getInt(getColumnIndex(RestaurantTable.Cols.R_FOODPRICE));
        String resFoodDesc = getString(getColumnIndex(RestaurantTable.Cols.R_FOODDESC));
        return new Restaurant(resName, resImage, resFoodName, resFoodImage, resFoodPrice, resFoodDesc);
    }

    public String getRestaurantName()
    {
        String resName = getString(getColumnIndex(RestaurantTable.Cols.R_NAME));

        return resName;
    }
}
