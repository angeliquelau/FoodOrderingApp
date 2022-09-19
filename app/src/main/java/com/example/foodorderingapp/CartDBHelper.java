package com.example.foodorderingapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.foodorderingapp.CartDBSchema.CartTable;

public class CartDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "cart.db";

    public CartDBHelper(Context context) { super(context, DATABASE_NAME, null, VERSION); }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + CartTable.NAME +
                "(" + CartTable.Cols.C_USERNAME + " Text, " + CartTable.Cols.C_FOODIMAGE + " Text, " +
                CartTable.Cols.C_NAME + " Text, " + CartTable.Cols.C_PRICE + " Text, " +
                CartTable.Cols.C_QUANTITY + " Text);");
    }

    //we won't be upgrading the database so we leave this empty
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
