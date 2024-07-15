package com.example.foodapp.Domain;

import android.os.Parcelable;

import java.io.Serializable;

public class Foods  implements Serializable  {
    private int CategoryId;
    private String Description;
    private boolean BestFood;
    private int id;
    private int LocationId;
    private double Price;
    private int Imagepath;
    private int PriceId;
    private double Star;
    private int TimeId;
    private  int TimeValue;
    private String Title;
    private int numberInCart;

    public Foods(int categoryId, String description, boolean bestFood, int id, int locationId, double price, int imagepath, int priceId, double star, int timeId, int timeValue, String title, int numberInCart) {
        CategoryId = categoryId;
        Description = description;
        BestFood = bestFood;
        this.id = id;
        LocationId = locationId;
        Price = price;
        Imagepath = imagepath;
        PriceId = priceId;
        Star = star;
        TimeId = timeId;
        TimeValue = timeValue;
        Title = title;
        this.numberInCart = numberInCart;
    }
    public Foods(){

    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isBestFood() {
        return BestFood;
    }

    public void setBestFood(boolean bestFood) {
        BestFood = bestFood;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocationId() {
        return LocationId;
    }

    public void setLocationId(int locationId) {
        LocationId = locationId;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getImagepath() {
        return Imagepath;
    }

    public void setImagepath(int imagepath) {
        Imagepath = imagepath;
    }

    public int getPriceId() {
        return PriceId;
    }

    public void setPriceId(int priceId) {
        PriceId = priceId;
    }

    public double getStar() {
        return Star;
    }

    public void setStar(double star) {
        Star = star;
    }

    public int getTimeId() {
        return TimeId;
    }

    public void setTimeId(int timeId) {
        TimeId = timeId;
    }

    public int getTimeValue() {
        return TimeValue;
    }

    public void setTimeValue(int timeValue) {
        TimeValue = timeValue;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @Override
    public String toString() {
        return Title;
    }
}