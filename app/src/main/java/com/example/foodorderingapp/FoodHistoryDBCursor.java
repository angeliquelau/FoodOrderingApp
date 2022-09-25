package com.example.foodorderingapp;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.example.foodorderingapp.FoodHistoryDBSchema.FoodHistoryTable;

public class FoodHistoryDBCursor extends CursorWrapper {

    public FoodHistoryDBCursor(Cursor cursor) { super(cursor); }

    public FoodHistory getFoodHistory(){
        String username = getString(getColumnIndex(FoodHistoryTable.Cols.FH_USERNAME));
        String foodName = getString(getColumnIndex(FoodHistoryTable.Cols.FH_NAME));
        int foodPrice = getInt(getColumnIndex(FoodHistoryTable.Cols.FH_PRICE));
        return new FoodHistory(username, foodName, foodPrice);
    }

    public String getFoodList()
    {
        return getString(getColumnIndex(FoodHistoryTable.Cols.FH_NAME));
    }

    public int getFoodPrice()
    {
        return getInt(getColumnIndex(FoodHistoryTable.Cols.FH_PRICE));
    }


}
