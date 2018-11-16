package com.WildBirds.RepositoryJPA.domain.ports;


import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.MealHasProduct;
import com.WildBirds.crudjpa.appliaction.interfaces.CrudEntity;

public interface RepositoryMealHasProduct extends CrudEntity<Meal> {
    MealHasProduct someAdditionalMethod();

}
