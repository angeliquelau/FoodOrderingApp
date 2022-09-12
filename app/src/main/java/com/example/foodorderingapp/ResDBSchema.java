package com.example.foodorderingapp;

/*Database for list of restaurants*/

public class ResDBSchema {
    public static class RestaurantTable {
        public static final String NAME = "restaurants";
        public static class Cols {
            //column names
            public static final String R_NAME = "res_name"; //restaurant's name
            public static final String R_IMAGE = "res_image"; //restaurant's image / logo
            //about the restaurant's food
            public static final String R_FOOD = "res_foodName"; //restaurant's food
            public static final String R_FOODIMAGE = "res_foodImage"; //restaurant's food image
            public static final String R_FOODPRICE = "res_foodPrice"; //restaurant's food price
            public static final String R_FOODDESC = "res_foodDesc"; //restaurant's food description

        }
    }
}
