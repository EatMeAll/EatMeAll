package com.WildBirds.EatMeAll.application.DTO;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class DayDTO {

    private Integer idDay;
    private Instant date;
    private Set<MealDTOshort> mealDTOshortSet;

    public DayDTO() {
        this.mealDTOshortSet = new HashSet<>();
    }

    public Integer getIdDay() {
        return idDay;
    }

    public void setIdDay(Integer idDay) {
        this.idDay = idDay;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Set<MealDTOshort> getMealDTOshortSet() {
        return mealDTOshortSet;
    }

    public void setMealDTOshortSet(Set<MealDTOshort> mealDTOshortSet) {
        this.mealDTOshortSet = mealDTOshortSet;
    }
}
