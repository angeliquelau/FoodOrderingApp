package com.example.foodorderingapp;

/*Database for logged in users*/

public class UserDBSchema {
    public static class UserTable{
        public static final String NAME = "users";
        public static class Cols {
            public static final String USERNAME = "username";
            public static final String EMAIL = "email";
            public static final String PASSWORD = "password";
        }
    }
}
