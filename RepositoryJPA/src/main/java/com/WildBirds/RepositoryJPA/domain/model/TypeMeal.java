package com.WildBirds.RepositoryJPA.domain.model;

import com.WildBirds.RepositoryJPA.domain.model.baseEntity.BaseEntity;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class TypeMeal extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTypeMeal;

    @Enumerated(EnumType.STRING)
    private MealTime mealTime;


//    @ManyToMany(mappedBy = "typeMeal", cascade = {CascadeType.MERGE, CascadeType.PERSIST})


    @ManyToMany(mappedBy = "typeMealSet" ,cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Meal> mealSet = new HashSet<>();

    public TypeMeal() {
    }

    public void addMeal(Meal meal){
        this.getMealSet().add(meal);
        meal.getTypeMealSet().add(this);
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

        if (idTypeMeal != null ? !idTypeMeal.equals(typeMeal.idTypeMeal) : typeMeal.idTypeMeal != null) return false;
        if (mealTime != typeMeal.mealTime) return false;
        return mealSet != null ? mealSet.equals(typeMeal.mealSet) : typeMeal.mealSet == null;
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
