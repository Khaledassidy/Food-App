package com.example.foodapp.Domain;

public class Price {
    private int id;
    private String value;

    public Price(int id, String value) {
        id = id;
        this.value = value;
    }

    public Price(String value) {
        this.value = value;
    }

    public Price() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
