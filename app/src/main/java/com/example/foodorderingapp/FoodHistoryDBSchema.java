package com.example.foodorderingapp;

/*Database for food order history of the logged in user*/

public class FoodHistoryDBSchema {
    public static class FoodHistoryTable {
        public static final String NAME = "foodOrderHistory";
        public static class Cols{
            //FH = food order history
            //column names
            public static final String FH_USERNAME = "username"; //user's username
            public static final String FH_NAME = "food_name";
            public static final String FH_PRICE = "food_price";
        }

    }
}
