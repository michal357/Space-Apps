package com.example.aleksandra.combined;

/**
 * Created by Aleksandra on 29.04.2017.
 */

public class User {

    private String name;
    private int rating;

    public User(){

    }

    public User(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
