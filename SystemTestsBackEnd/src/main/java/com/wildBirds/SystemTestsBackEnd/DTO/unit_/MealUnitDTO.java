package com.wildBirds.SystemTestsBackEnd.DTO.unit_;

import com.wildBirds.SystemTestsBackEnd.DTO.enums.Language;
import com.wildBirds.SystemTestsBackEnd.DTO.enums.MealTime;

public class MealUnitDTO {

    private Integer idMeal;
    private Language language;
    private String title;
    private String shortDescription;
    private Boolean isPublic;
    private MealTime mealTime;

    public MealUnitDTO() {
    }

    public MealUnitDTO(Integer idMeal, Language language, String title, String shortDescription, Boolean isPublic, MealTime mealTime) {
        this.idMeal = idMeal;
        this.language = language;
        this.title = title;
        this.shortDescription = shortDescription;
        this.isPublic = isPublic;
        this.mealTime = mealTime;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public MealTime getMealTime() {
        return mealTime;
    }

    public void setMealTime(MealTime mealTime) {
        this.mealTime = mealTime;
    }
}