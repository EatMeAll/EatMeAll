package com.WildBirds.RepositoryJPA.domain.ports;


import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.TypeMeal;
import com.WildBirds.crudjpa.appliaction.interfaces.CrudEntity;

public interface RepositoryTypeMeal extends CrudEntity<TypeMeal> {
    TypeMeal someAdditionalLogic();
}
