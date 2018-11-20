package com.WildBirds.EatMeAll.application.service;

import com.WildBirds.EatMeAll.application.modelDTO.MealDTO;
import com.WildBirds.EatMeAll.application.modelDTO.UserDTO;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.User;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

public interface Mapper {

    List<Meal> toMeal(List<MealDTO> mealDTOList);
    List<MealDTO> toMealDTO(List<Meal> mealList);
    UserDTO toUserDTO(User user);
    User toUser(UserDTO userDTO);
}
