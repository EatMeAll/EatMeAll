package com.WildBirds.EatMeAll.application.controlers.service;


import com.WildBirds.RepositoryJPA.application.RepositoryFacade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class MealServiceTypeMeal {

    @EJB
    RepositoryFacade repo;




    //todo THINKING ABOUT NAME - SHOULD IMPLEMENTS IN RepositoryTypeMeal ? IN RepositoryMeal
    // todo Because I thing that almost all repository will be returning Meal but in special forms

//    public List<MealDTO> getMeals(MealTime mealTime, Language language, Integer amount, Boolean isPublic, List<String> listProducts) {
//
//        List<Meal> mealList = repo.MEAL().getMealsByTypeMeal(mealTime, language, amount, isPublic, listProducts);
//
//        List<MealDTO> mealDTOList = mapperMeal.toMealDTO(mealList);
//        return mealDTOList;
//    }
//
//    public List<MealDTO> getMeals(MealTime mealTime, Language language, Integer amount, Boolean isPublic) {
//        List<Meal> mealList = repo.MEAL().getMealsByTypeMeal(mealTime, language, amount, isPublic);
//
//        List<MealDTO> mealDTOList = mapperMeal.toMealDTO(mealList);
//        return mealDTOList;
//
//    }
//
//    public List<MealDTO> getMeals(MealTime mealTime, Language language, Integer amount) {
//        List<Meal> mealList = repo.MEAL().getMealsByTypeMeal(mealTime, language, amount);
//
//        List<MealDTO> mealDTOList = mapperMeal.toMealDTO(mealList);
//        return mealDTOList;
//
//    }
//
//    public List<MealDTO> getMeals(MealTime mealTime, Language language) {
//        List<Meal> mealList = repo.MEAL().getMealsByTypeMeal(mealTime, language);
//
//        List<MealDTO> mealDTOList = mapperMeal.toMealDTO(mealList);
//        return mealDTOList;
//    }
}
