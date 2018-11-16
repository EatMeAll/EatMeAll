package com.WildBirds.RepositoryJPA.domain.ports;


import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.crudjpa.appliaction.interfaces.CrudEntity;

public interface RepositoryMeal extends CrudEntity<Meal> {

    Meal someAdditionalLogic();
}
