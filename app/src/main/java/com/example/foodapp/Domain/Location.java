package com.example.foodapp.Domain;

public class Location {
    private int id;
    private String loc;

    public Location(int id, String loc) {
        id = id;
        this.loc = loc;
    }
    public Location(String loc) {
        this.loc = loc;
    }
    public Location(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return loc;
    }
}
