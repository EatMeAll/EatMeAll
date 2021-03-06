package com.WildBirds.RepositoryJPA.domain.ports;


import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.interfaces.CrudEntity;

import java.io.File;
import java.util.List;

public interface RepositoryMeal extends CrudEntity<Meal> {

    Meal someAdditionalLogic();

    List<Meal> getMealsByTypeMeal(MealTime mealTime, Language language, Integer amount, Boolean isPublic, List<String> listProducts);
    List<Meal> getMealsByTypeMeal(MealTime mealTime, Language language, Integer amount, Boolean isPublic);
    List<Meal> getMealsByTypeMeal(MealTime mealTime, Language language, Integer amount);
    List<Meal> getMealsByTypeMeal(MealTime mealTime, Language language);
    List<Meal> getMealsByTypeMeal(MealTime mealTime);


    //MealTime mealTime, Language language, Integer amount
    List<Meal> getShortMealByTypeMeal(MealTime mealTime, Language language, Integer amount);

    File getFile(int idPhoto);
}
