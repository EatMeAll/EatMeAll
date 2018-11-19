package com.WildBirds.RepositoryJPA.domain.ports;


import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.interfaces.CrudEntity;

import java.util.List;

public interface RepositoryMeal extends CrudEntity<Meal> {

    Meal someAdditionalLogic();

    List<Meal> getMealsByMealTeam(MealTime mealTime);
}
