package com.wildBirds.SystemTestsBackEnd.domain.model.full_;



import com.wildBirds.SystemTestsBackEnd.domain.model.unit_.MealUnitDTO;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class DayDTO {

    private Integer idDay;
    private Instant date;
    private Set<MealUnitDTO> meals;

    public DayDTO() {
        this.meals = new HashSet<>();
    }

    public DayDTO(Integer idDay, Instant date) {
        this.idDay = idDay;
        this.date = date;
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

    public Set<MealUnitDTO> getMeals() {
        return meals;
    }

    public void setMeals(Set<MealUnitDTO> meals) {
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "DayDTO{" +
                "idDay=" + idDay +
                ", date=" + date +
                '}';
    }
}
