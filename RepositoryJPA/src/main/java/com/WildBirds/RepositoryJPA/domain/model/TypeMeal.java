package com.WildBirds.RepositoryJPA.domain.model;

import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TypeMeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTypeMeal;

    @Enumerated(EnumType.STRING)
    private MealTime mealTime;


//    @ManyToMany(mappedBy = "typeMeal", cascade = {CascadeType.MERGE, CascadeType.PERSIST})


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "MealHasTypeMeal",
            joinColumns = {@JoinColumn(name = "idTypeMeal")},
            inverseJoinColumns = {@JoinColumn(name = "idMeal")})
    private Set<Meal> mealSet = new HashSet<>();

    public TypeMeal() {
    }

    public Integer getIdTypeMeal() {
        return idTypeMeal;
    }

    public void setIdTypeMeal(Integer idTypeMeal) {
        this.idTypeMeal = idTypeMeal;
    }

    public MealTime getMealTime() {
        return mealTime;
    }

    public void setMealTime(MealTime mealTime) {
        this.mealTime = mealTime;
        this.setIdTypeMeal(mealTime.getIndex());
    }

    public Set<Meal> getMealSet() {
        return mealSet;
    }

    public void setMealSet(Set<Meal> mealSet) {
        this.mealSet = mealSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeMeal typeMeal = (TypeMeal) o;

        return mealTime == typeMeal.mealTime;
    }

    @Override
    public int hashCode() {
        return mealTime != null ? mealTime.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TypeMeal{" +
                "idTypeMeal=" + idTypeMeal +
                ", mealTime=" + mealTime +
                ", mealSet=" + mealSet +
                '}';
    }
}
