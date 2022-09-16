package com.example.foodorderingapp;

public class Restaurant {
    public String resName;
    public String resImage;
    public String resFoodName;
    public String resFoodImage;
    public double resFoodPrice;
    public String resFoodDesc;

    //constructor
    public Restaurant(String resName, String resImage, String resFoodName, String resFoodImage, double resFoodPrice, String resFoodDesc)
    {
        this.resName = resName;
        this.resImage = resImage;
        this.resFoodName = resFoodName;
        this.resFoodImage = resFoodImage;
        this.resFoodPrice = resFoodPrice;
        this.resFoodDesc = resFoodDesc;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "resName='" + resName + '\'' +
                ", resImage='" + resImage + '\'' +
                ", resFoodName='" + resFoodName + '\'' +
                ", resFoodImage='" + resFoodImage + '\'' +
                ", resFoodPrice=" + resFoodPrice +
                ", resFoodDesc='" + resFoodDesc + '\'' +
                '}';
    }

    //setters and getters
    public String getResName() { return resName; }
    public void setResName(String resName) { this.resName = resName; }

    public String getResImage() { return resImage; }
    public void setResImage(String resImage) { this.resImage = resImage; }

    public String getResFoodName() { return resFoodName; }
    public void setResFoodName(String resFoodName) { this.resFoodName = resFoodName; }

    public String getResFoodImage() { return resFoodImage; }
    public void setResFoodImage(String resFoodImage) { this.resFoodImage = resFoodImage; }

    public double getResFoodPrice() { return resFoodPrice; }
    public void setResFoodPrice(double resFoodPrice) { this.resFoodPrice = resFoodPrice; }

    public String getResFoodDesc() { return resFoodDesc; }
    public void setResFoodDesc(String resFoodDesc) { this.resFoodDesc = resFoodDesc; }



}
