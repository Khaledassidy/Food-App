package com.example.foodapp.Domain;

import android.os.Parcelable;
import android.provider.ContactsContract;

import java.io.Serializable;

public class Foods  implements Serializable  {
    private int CategoryId;
    private String Description;
    private boolean BestFood;
    private int id;
    private int LocationId;
    private double Price;
    private String Imagepath;
    private int PriceId;
    private double Star;
    private int TimeId;
    private  int TimeValue;
    private String Title;
    private int numberInCart;
    private boolean incart;

    public Foods(int categoryId, String description, String Imagepath, double Price, double Star, int TimeValue, String Title,boolean incart,int numberInCart,int id,int locationId,int priceId,int TimeId,boolean bestFood) {
        this.CategoryId=categoryId;
        this.Description = description;
        this.Imagepath = Imagepath;
        this.Price = Price;
        this.Star=Star;
        this.TimeValue = TimeValue;
        this.Title = Title;
        this.incart=incart;
        this.numberInCart = numberInCart;
        this.id = id;
        this.LocationId = locationId;
        this.PriceId = priceId;
        this.TimeId = TimeId;
        this.BestFood=bestFood;
    }
    public Foods(int categoryId, String description, String Imagepath, double Price, double Star, int TimeValue, String Title,boolean incart,int numberInCart,int locationId,int priceId,int TimeId,boolean bestfood) {
        CategoryId = categoryId;
        Description = description;
        this.Imagepath = Imagepath;
        this.Price = Price;
        this.Star=Star;
        this.TimeValue = TimeValue;
        this.Title = Title;
        this.incart=incart;
        this.numberInCart = numberInCart;
        LocationId = locationId;
        PriceId = priceId;
        this.TimeId = TimeId;
        this.BestFood=bestfood;


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

    public String getImagepath() {
        return Imagepath;
    }

    public void setImagepath(String imagepath) {
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
        Star = Star;
    }

    public int getTimeId() {
        return TimeId;
    }

    public void setTimeId(int timeId) {
        TimeId = TimeId;
    }

    public int getTimeValue() {
        return TimeValue;
    }

    public void setTimeValue(int timeValue) {
        TimeValue = TimeValue;
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
        Title = Title;
    }

    public boolean isIncart() {
        return incart;
    }

    public void setIncart(boolean incart) {
        this.incart = incart;
    }

    @Override
    public String toString() {
        return Title;
    }
}
