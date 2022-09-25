package com.example.foodorderingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.foodorderingapp.UserDBSchema.UserTable;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            while(!cursor.isAfterLast()){
                userList.add(userDBCursor.getUser());
                cursor.moveToNext();
            }
        }
        finally{
            cursor.close();
        }

        return userList;
    }

    public String getUsername(String email)
    {
        String username = "";
        Cursor cursor = db.rawQuery("select " + UserTable.Cols.USERNAME + " from " +
                UserTable.NAME + " where " + UserTable.Cols.EMAIL + " = ? ", new String[] {email});
        UserDBCursor userDBCursor = new UserDBCursor(cursor);
        try{
            cursor.moveToFirst(); //move cursor to the first data in the database
            //while not at the end of the database, loop to add the data into the array list
            while(!cursor.isAfterLast()){
                username = userDBCursor.getUsername();
                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return username;
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

        cursor.close();

        return exist;
    }

    public boolean checkEmail(String email)
    {
        boolean exist = false;
        Cursor cursor = db.rawQuery("select * from " + UserTable.NAME + " where " + UserTable.Cols.EMAIL + " = ? ", new String[] {email});

        if(cursor.getCount() > 0)
        {
            exist = true;
        }

        cursor.close();

        return exist;
    }

    public boolean validateEmail(String email)
    {
        //referred to: https://mailtrap.io/blog/java-email-validation/
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public boolean checkEmailPassword (String username, String password)
    {
        boolean exist = false;
        Cursor cursor = db.rawQuery("select * from " + UserTable.NAME + " where " +
                UserTable.Cols.EMAIL + " = ?" + " AND "
                + UserTable.Cols.PASSWORD + " = ?", new String[] {username, password});

        if(cursor.getCount() > 0)
        {
            exist = true;
        }

        cursor.close();
        return exist;
    }
}
