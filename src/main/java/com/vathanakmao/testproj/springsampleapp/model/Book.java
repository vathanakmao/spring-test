package com.vathanakmao.testproj.springsampleapp.model;

import org.hibernate.validator.constraints.NotBlank;

public class Book {

    @NotBlank
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    private int    publishedYear;

    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int year) {
        this.publishedYear = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
