package com.wildBirds.SystemTestsBackEnd.domain.model.short_;

import com.wildBirds.SystemTestsBackEnd.domain.model.enums.Language;
import com.wildBirds.SystemTestsBackEnd.domain.model.enums.MealTime;

import java.util.Set;

public class MealShortDTO {

    private Integer idMeal;
    private Language language;
    private String title;
    private String shortDescription;
    private Boolean isPublic;
    private Set<MealTime> mealTimeSet;

    public MealShortDTO() {
    }

    public MealShortDTO(Integer idMeal, Language language, String title, String shortDescription, Boolean isPublic, Set<MealTime> mealTimeSet) {
        this.idMeal = idMeal;
        this.language = language;
        this.title = title;
        this.shortDescription = shortDescription;
        this.isPublic = isPublic;
        this.mealTimeSet = mealTimeSet;
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

    public Set<MealTime> getMealTimeSet() {
        return mealTimeSet;
    }

    public void setMealTimeSet(Set<MealTime> mealTimeSet) {
        this.mealTimeSet = mealTimeSet;
    }
}
