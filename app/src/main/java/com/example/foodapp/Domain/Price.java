package com.example.foodapp.Domain;

public class Price {
    private int Id;
    private String value;

    public Price(int id, String value) {
        Id = id;
        this.value = value;
    }

    public Price() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
