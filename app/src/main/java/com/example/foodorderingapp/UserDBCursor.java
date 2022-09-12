package com.example.foodorderingapp;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.example.foodorderingapp.UserDBSchema.UserTable;

public class UserDBCursor extends CursorWrapper {
    public UserDBCursor(Cursor cursor) { super(cursor); }

    public User getUser(){
        String username = getString(getColumnIndex(UserTable.Cols.USERNAME));
        String email = getString(getColumnIndex(UserTable.Cols.EMAIL));
        String password = getString(getColumnIndex(UserTable.Cols.PASSWORD));
        return new User(username, email, password);
    }
}
