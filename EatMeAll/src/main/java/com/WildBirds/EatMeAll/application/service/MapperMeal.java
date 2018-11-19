package com.WildBirds.EatMeAll.application.service;

import com.WildBirds.EatMeAll.application.modelDTO.MealDTO;
import com.WildBirds.RepositoryJPA.domain.model.Meal;

import java.util.List;

public interface MapperMeal {

    List<Meal> listMealDTOtoMeal (List<MealDTO> mealDTOList);
    List<MealDTO> listMealtoMealDTO (List<Meal> mealList);
}
