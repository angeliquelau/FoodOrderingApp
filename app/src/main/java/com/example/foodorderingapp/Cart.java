package com.example.foodorderingapp;

/*naming might get confusing but this is suppose to represent a cart item*/

public class Cart {
    public String username;
    public String foodName;
    public int foodPrice;
    public int quantity;

    public Cart(String username, String foodName, int foodPrice, int quantity)
    {
        this.username = username;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.quantity = quantity;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getFoodName() { return foodName; }
    public void setFoodName(String foodName) { this.foodName = foodName; }

    public int getFoodPrice() { return foodPrice; }
    public void setFoodPrice(int foodPrice) { this.foodPrice = foodPrice; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
