package com.WildBirds.RepositoryJPA.domain.model;

import com.WildBirds.RepositoryJPA.domain.model.baseEntity.BaseEntity;

import javax.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Day extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDay;
    private Instant date;

    @ManyToOne()
    @JoinColumn(name = "idUser")
    private User dayOwner;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "day")
    private Set<MealHasDay> mealHasDaySet = new HashSet<>();

    public Day() {
    }


    public void addMealHasDay(MealHasDay mealHasDay){
        this.getMealHasDaySet().add(mealHasDay);
        mealHasDay.setDay(this);
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

    public User getDayOwner() {
        return dayOwner;
    }

    public void setDayOwner(User dayOwner) {
        this.dayOwner = dayOwner;
        dayOwner.getHistoryMealsSet().add(this);
    }


    public Set<MealHasDay> getMealHasDaySet() {
        return mealHasDaySet;
    }

    public void setMealHasDaySet(Set<MealHasDay> mealHasDay) {
        this.mealHasDaySet = mealHasDay;
    }
}
