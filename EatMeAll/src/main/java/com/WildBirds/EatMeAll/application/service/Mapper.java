package com.WildBirds.EatMeAll.application.service;

import com.WildBirds.EatMeAll.application.DTO.MealDTO;
import com.WildBirds.EatMeAll.application.DTO.MealDTOshort;
import com.WildBirds.EatMeAll.application.DTO.NewUserDTO;
import com.WildBirds.EatMeAll.application.DTO.UserDTO;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.User;

import java.util.List;

public interface Mapper {

    List<Meal> toMeal(List<MealDTO> mealDTOList);
    List<MealDTO> toMealDTO(List<Meal> mealList);
    UserDTO toUserDTO(User user);
    User toUser(UserDTO userDTO);
    User toUser(NewUserDTO newUserDTO);

    MealDTOshort toMealDTOShort(Meal meal);
}
