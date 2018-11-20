//package com.WildBirds.EatMeAll.application.controlers.service;
//
//
//import com.WildBirds.EatMeAll.application.modelDTO.MealDTO;
//import com.WildBirds.EatMeAll.application.service.MapperMeal;
//import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
//import com.WildBirds.RepositoryJPA.domain.model.Meal;
//import com.WildBirds.RepositoryJPA.domain.model.enums.Language;
//import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;
//
//import javax.ejb.EJB;
//import javax.ejb.LocalBean;
//import javax.ejb.Stateless;
//import java.util.List;
//
//@Stateless
//@LocalBean
//public class MealServiceTypeMeal {
//
//    @EJB
//    RepositoryFacade repo;
//
////    @EJB
//    MapperMeal mapperMeal;
//
//
//    //todo THINKING ABOUT NAME - SHOULD IMPLEMENTS IN RepositoryTypeMeal ? IN RepositoryMeal
//    // todo Because I thing that almost all repository will be returning Meal but in special forms
//
//    public List<MealDTO> getMeals(MealTime mealTime, Language language, Integer amount, Boolean isPublic, List<String> listProducts) {
//
//        List<Meal> mealList = repo.MEAL().getMealsByTypeMeal(mealTime, language, amount, isPublic, listProducts);
//
//        List<MealDTO> mealDTOList = mapperMeal.listMealtoMealDTO(mealList);
//        return mealDTOList;
//    }
//
//    public List<MealDTO> getMeals(MealTime mealTime, Language language, Integer amount, Boolean isPublic) {
//        List<Meal> mealList = repo.MEAL().getMealsByTypeMeal(mealTime, language, amount, isPublic);
//
//        List<MealDTO> mealDTOList = mapperMeal.listMealtoMealDTO(mealList);
//        return mealDTOList;
//
//    }
//
//    public List<MealDTO> getMeals(MealTime mealTime, Language language, Integer amount) {
//        List<Meal> mealList = repo.MEAL().getMealsByTypeMeal(mealTime, language, amount);
//
//        List<MealDTO> mealDTOList = mapperMeal.listMealtoMealDTO(mealList);
//        return mealDTOList;
//
//    }
//
//    public List<MealDTO> getMeals(MealTime mealTime, Language language) {
//        List<Meal> mealList = repo.MEAL().getMealsByTypeMeal(mealTime, language);
//
//        List<MealDTO> mealDTOList = mapperMeal.listMealtoMealDTO(mealList);
//        return mealDTOList;
//    }
//}
