package com.WildBirds.EatMeAll.application.service;

import com.WildBirds.EatMeAll.application.DTO.*;
import com.WildBirds.RepositoryJPA.domain.model.Day;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.Product;
import com.WildBirds.RepositoryJPA.domain.model.User;

import java.util.List;

public interface Mapper {

    List<Meal> toMeal(List<MealDTO> mealDTOList);
    List<MealDTO> toMealDTO(List<Meal> mealList);

    UserDTO toUserDTO(User user);
    User toUser(UserDTO userDTO);
    User toUser(NewUserDTO newUserDTO);

    MealDTOshort toMealDTOShort(Meal meal);
    MealDTOshortFull toMealDTOShortFull(Meal meal);


    ProductBasicDTO toProductBasicDTO(Product product);

    DayDTO toDayDTO(Day day);
    List<DayDTO> toDayDTO(List<Day> dayList);

    Day toDay(DayDTO dayDTO, Integer idUser);
    List<Day> toDay(List<DayDTO> dayDTOList, Integer idUser);
}
