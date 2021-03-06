package com.WildBirds.EatMeAll.application.service;

import com.WildBirds.EatMeAll.application.DTO.full_.DayDTO;
import com.WildBirds.EatMeAll.application.DTO.full_.MealDTO;
import com.WildBirds.EatMeAll.application.DTO.full_.ProductDTO;
import com.WildBirds.EatMeAll.application.DTO.full_.UserDTO;
import com.WildBirds.EatMeAll.application.DTO.new_.UserNewDTO;
import com.WildBirds.EatMeAll.application.DTO.short_.MealShortDTO;
import com.WildBirds.EatMeAll.application.DTO.unit_.MealUnitDTO;
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
    User toUser(UserNewDTO userNewDTO);

    MealUnitDTO toMealUnitDTO(Meal meal);
    MealShortDTO toMealShortDTO(Meal meal);


    ProductDTO toProductDTO(Product product);

    Product toProduct(ProductDTO productDTO);

    DayDTO toDayDTO(Day day);
    List<DayDTO> toDayDTO(List<Day> dayList);

    Day toDay(DayDTO dayDTO, Integer idUser);
    List<Day> toDay(List<DayDTO> dayDTOList, Integer idUser);
}
