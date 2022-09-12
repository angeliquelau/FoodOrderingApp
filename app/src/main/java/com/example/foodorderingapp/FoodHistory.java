package com.example.foodorderingapp;

public class FoodHistory {
    public String username;
    public String foodName;
    public int foodPrice;

    public FoodHistory(String username, String foodName, int foodPrice)
    {
        this.username = username;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getFoodName() { return foodName; }
    public void setFoodName(String foodName) { this.foodName = foodName; }

    public int getFoodPrice() { return foodPrice; }

    public void setFoodPrice(int foodPrice) { this.foodPrice = foodPrice; }
}
