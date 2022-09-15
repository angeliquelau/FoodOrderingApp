package com.example.foodorderingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.foodorderingapp.UserDBSchema.UserTable;

import java.util.ArrayList;

public class UserDBModel {
    SQLiteDatabase db;

    public void load(Context context) { this.db = new UserDBHelper(context).getWritableDatabase(); }

    public void addUser(User user) {
        ContentValues cv = new ContentValues();
        cv.put(UserTable.Cols.USERNAME, user.getUsername());
        cv.put(UserTable.Cols.EMAIL, user.getEmail());
        cv.put(UserTable.Cols.PASSWORD, user.getPassword());
        db.insert(UserTable.NAME, null, cv); // add user into database
    }

    public ArrayList<User> getAllUser() {
        ArrayList<User> userList = new ArrayList<>();
        Cursor cursor = db.query(UserTable.NAME, null, null, null, null, null, null);
        UserDBCursor userDBCursor = new UserDBCursor(cursor);

        try{
            cursor.moveToFirst(); //move cursor to the first data in the database
            //while not at the end of the database, loop to add the data into the array list
            while(!userDBCursor.isAfterLast()){
                userList.add(userDBCursor.getUser());
                userDBCursor.moveToNext();
            }
        }
        finally{
            cursor.close();
        }

        return userList;
    }

    public boolean checkUsername (String username)
    {
        Log.i("UserDBModel", username);

        boolean exist = false;
        Cursor cursor = db.rawQuery("select * from " + UserTable.NAME + " where " + UserTable.Cols.USERNAME + " = ? ", new String[] {username});

        if(cursor.getCount() > 0)
        {
            exist = true;
        }

        return exist;
    }

    public boolean checkUsernamePassword (String username, String password)
    {
        boolean exist = false;
        Cursor cursor = db.rawQuery("select * from " + UserTable.NAME + " where " + UserTable.Cols.USERNAME + " = ? ", new String[] {username, password});

        if(cursor.getCount() > 0)
        {
            exist = true;
        }

        return exist;
    }
}
