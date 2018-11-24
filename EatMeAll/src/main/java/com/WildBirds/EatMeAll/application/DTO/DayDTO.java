package com.WildBirds.EatMeAll.application.DTO;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class DayDTO {

    private Integer idDay;
    private Instant date;
    private List<MealDTOshort> mealDTOShortList;

    public DayDTO() {
        this.mealDTOShortList = new ArrayList<>();
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

    public List<MealDTOshort> getMealDTOShortList() {
        return mealDTOShortList;
    }

    public void setMealDTOShortList(List<MealDTOshort> mealDTOShortList) {
        this.mealDTOShortList = mealDTOShortList;
    }
}
