package com.example.foodapp.Domain;

public class Category {
    private int id;
    private int imagepath;
    private String name;

    public Category(int id, int imagepath, String name) {
        this.id = id;
        this.imagepath = imagepath;
        this.name = name;
    }
    public Category(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagepath() {
        return imagepath;
    }

    public void setImagepath(int imagepath) {
        this.imagepath = imagepath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
