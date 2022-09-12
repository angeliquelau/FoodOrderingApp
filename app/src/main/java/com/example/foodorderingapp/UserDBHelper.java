package com.example.foodorderingapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.foodorderingapp.UserDBSchema.UserTable;

public class UserDBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "users.db";

    //constructor
    public UserDBHelper(Context context) { super(context, DATABASE_NAME, null, VERSION); }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //creating database with sqlite command
        sqLiteDatabase.execSQL("create table " + UserTable.NAME + "(" + UserTable.Cols.USERNAME + " Text, " +
                UserTable.Cols.EMAIL + " Text, " + UserTable.Cols.PASSWORD + " Text);");
    }

    //we won't be upgrading the database so we leave this empty
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
