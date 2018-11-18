package com.WildBirds.RepositoryJPA.domain.model;

import javax.persistence.*;

import java.security.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDay;
    private Instant date;

    @ManyToOne()
    @JoinColumn(name = "idUser")
    private User dayOwner;

//    @ManyToMany(mappedBy = "usedInDays", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    private Set<Meal> mealsSet = new HashSet<>();

    public Day() {
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
    }

//    public Set<Meal> getMealsSet() {
//        return mealsSet;
//    }
//
//    public void setMealsSet(Set<Meal> mealsSet) {
//        this.mealsSet = mealsSet;
//    }
}
