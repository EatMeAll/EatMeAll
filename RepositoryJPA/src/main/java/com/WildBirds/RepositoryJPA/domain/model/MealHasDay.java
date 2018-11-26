package com.WildBirds.RepositoryJPA.domain.model;


import com.WildBirds.RepositoryJPA.domain.model.baseEntity.BaseEntity;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;

import javax.persistence.*;

@Entity
public class MealHasDay extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMealHasDay;

    @ManyToOne
    @JoinColumn(name = "idMeal")
    private Meal meal;

    @ManyToOne
    @JoinColumn(name = "idDay")
    private Day day;

    @Enumerated(EnumType.STRING)
    private MealTime mealTime;

    public MealHasDay() {
    }

    public Integer getIdMealHasDay() {
        return idMealHasDay;
    }

    public void setIdMealHasDay(Integer idMealHasDay) {
        this.idMealHasDay = idMealHasDay;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
        meal.getMealHasDaySet().add(this);
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
        day.getMealHasDaySet().add(this);
    }

    public MealTime getMealTime() {
        return mealTime;
    }

    public void setMealTime(MealTime mealTime) {
        this.mealTime = mealTime;
    }
}
