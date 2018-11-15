package com.WildBirds.EatMeAll.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;
public class Meal {
    private Integer idMeal;
    private Language language;
    private List<TypeMeal> typeMeal;
    private Integer prepareTime;
    private String title;
    private List<MealHasProduct> mealHasProductList;
    private String receipt;
    private String description;
    private Integer amountCalories;
    private String authorReceipt;
    private File photo;

    public Meal() {
    }

    public Integer getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(Integer idMeal) {
        this.idMeal = idMeal;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<TypeMeal> getTypeMeal() {
        return typeMeal;
    }

    public void setTypeMeal(List<TypeMeal> typeMeal) {
        this.typeMeal = typeMeal;
    }

    public Integer getPrepareTime() {
        return prepareTime;
    }

    public void setPrepareTime(Integer prepareTime) {
        this.prepareTime = prepareTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MealHasProduct> getMealHasProductList() {
        return mealHasProductList;
    }

    public void setMealHasProductList(List<MealHasProduct> mealHasProductList) {
        this.mealHasProductList = mealHasProductList;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmountCalories() {
        return amountCalories;
    }

    public void setAmountCalories(Integer amountCalories) {
        this.amountCalories = amountCalories;
    }

    public String getAuthorReceipt() {
        return authorReceipt;
    }

    public void setAuthorReceipt(String authorReceipt) {
        this.authorReceipt = authorReceipt;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }
}
