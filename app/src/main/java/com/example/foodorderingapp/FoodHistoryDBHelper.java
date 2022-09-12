package com.example.foodorderingapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.foodorderingapp.FoodHistoryDBSchema.FoodHistoryTable;

public class FoodHistoryDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "foodhistory.db";

    public FoodHistoryDBHelper(Context context) { super(context, DATABASE_NAME, null, VERSION); }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + FoodHistoryTable.NAME +
                "(" + FoodHistoryTable.Cols.FH_USERNAME + " Text, " + FoodHistoryTable.Cols.FH_NAME + " Text, " +
                FoodHistoryTable.Cols.FH_PRICE + " Text);");
    }

    //we won't be upgrading the database so we leave this empty
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
