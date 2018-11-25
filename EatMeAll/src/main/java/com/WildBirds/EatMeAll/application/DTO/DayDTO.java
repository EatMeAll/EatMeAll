package com.WildBirds.EatMeAll.application.DTO;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class DayDTO {

    private Integer idDay;
    private Instant date;
    private Set<MealDTOshort> mealDTOShortList;

    public DayDTO() {
        this.mealDTOShortList = new HashSet<>();
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

    public Set<MealDTOshort> getMealDTOShortList() {
        return mealDTOShortList;
    }

    public void setMealDTOShortList(Set<MealDTOshort> mealDTOShortList) {
        this.mealDTOShortList = mealDTOShortList;
    }
}
