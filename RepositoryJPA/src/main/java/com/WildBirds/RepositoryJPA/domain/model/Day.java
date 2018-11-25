package com.WildBirds.RepositoryJPA.domain.model;

import com.WildBirds.RepositoryJPA.domain.model.baseEntity.BaseEntity;

import javax.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
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

    @ManyToMany(mappedBy = "usedInDaysSet",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Meal> mealsSet = new HashSet<>();

    public Day() {
    }

    public void addMeal(Meal meal){
        this.getMealsSet().add(meal);
        meal.getUsedInDaysSet().add(this);
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

    public Set<Meal> getMealsSet() {
        return mealsSet;
    }
    public void setMealsSet(Set<Meal> mealsSet) {
        this.mealsSet = mealsSet;
    }

}
