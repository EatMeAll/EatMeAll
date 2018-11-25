package com.WildBirds.EatMeAll.application.service;

import com.WildBirds.EatMeAll.application.DTO.*;
import com.WildBirds.RepositoryJPA.domain.model.Day;
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

    DayDTO toDayDTO(Day day);
    Day toDay(DayDTO dayDTO, Integer idUser);
}
