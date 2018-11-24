package com.WildBirds.EatMeAll.application.DTO;

import com.WildBirds.RepositoryJPA.domain.model.enums.Language;

public class MealDTOshort {

    private Integer idMeal;
    private Language language;
    private String title;
    private String shortDescription;
    private Boolean isPublic;

    public MealDTOshort() {
    }

    public MealDTOshort(Integer idMeal, Language language, String title, String shortDescription, Boolean isPublic) {
        this.idMeal = idMeal;
        this.language = language;
        this.title = title;
        this.shortDescription = shortDescription;
        this.isPublic = isPublic;
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
}
