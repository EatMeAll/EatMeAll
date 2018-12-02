package com.domain.model;

import java.util.List;

public class MealExcel {

    private Double id;
    private String typeMeal;
    private Integer prepaidTime;
    private String title;
    private List<ProductsExcel> products;
    private String receipt;
    private Double calories;
    private String author;

    public MealExcel() {
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getTypeMeal() {
        return typeMeal;
    }

    public void setTypeMeal(String typeMeal) {
        this.typeMeal = typeMeal;
    }

    public Integer getPrepaidTime() {
        return prepaidTime;
    }

    public void setPrepaidTime(Integer prepaidTime) {
        this.prepaidTime = prepaidTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProductsExcel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsExcel> products) {
        this.products = products;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "MealExcel " +
                "id             :" + id + '\n'+
                "typeMeal       : " + typeMeal + '\n' +
                "prepaidTime    :" + prepaidTime + '\n' +
                "title          :" + title + '\n' +
                "products       :" + products +
                "receipt        :" + receipt + '\n' +
                "calories       :" + calories + '\n' +
                "author         :" + author + '\n';
    }
}
