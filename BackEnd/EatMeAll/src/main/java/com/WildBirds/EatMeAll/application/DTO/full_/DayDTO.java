package com.WildBirds.EatMeAll.application.DTO.full_;

import com.WildBirds.EatMeAll.application.DTO.unit_.MealUnitDTO;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DayDTO {

    private Integer idDay;
    private Instant date;
    private List<MealUnitDTO> meals;

    public DayDTO() {
        this.meals = new ArrayList<>();
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

    public List<MealUnitDTO> getMeals() {
        return meals;
    }

    public void setMeals(List<MealUnitDTO> meals) {
        this.meals = meals;
    }
}
