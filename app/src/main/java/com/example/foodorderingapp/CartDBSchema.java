package com.example.foodorderingapp;

public class CartDBSchema {
    public static class CartTable {
        public static final String NAME = "Cart";
        public static class Cols{
            //column names
            public static final String C_USERNAME = "username"; //user's usernam
            public static final String C_NAME = "food_name";
            public static final String C_PRICE = "food_price";
            public static final String C_QUANTITY = "quantity";
        }

    }
}
