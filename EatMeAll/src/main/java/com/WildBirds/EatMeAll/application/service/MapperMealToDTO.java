package com.WildBirds.EatMeAll.application.service;

import com.WildBirds.EatMeAll.application.modelDTO.MealDTO;
import com.WildBirds.EatMeAll.application.modelDTO.ProductDTO;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.MealHasProduct;
import com.WildBirds.RepositoryJPA.domain.model.Product;
import com.WildBirds.RepositoryJPA.domain.model.TypeMeal;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;

import java.util.ArrayList;
import java.util.List;


public class MapperMealToDTO {

    private Language language;
    private Meal meal;
    private MealHasProduct mealHasProduct;
    private List<Product> products;
    private List<TypeMeal> typeMeal;

    private List<ProductDTO> getProducts() {
        // TODO: 05.11.2018 Write Implementation
        ArrayList<ProductDTO> productDTOS = new ArrayList<>();

        return productDTOS;
    }

    public MealDTO getMealDTO() {
        MealDTO mealDTO = new MealDTO();

//        MealDTO.builder()
//                .idMeal(meal.getIdMeal())
//                .language(language)
//                .typeMeal(meal.getTypeMeal())
//                .prepaidTime(meal.getPrepareTime())
//                .title(meal.getTitle())
//                .products(getProducts())
//                .receipt(meal.getReceipt())
//                .description(meal.getDescription())
//                .amountCalories(meal.getAmountCalories())
//                .authorReceipt(meal.getAuthorReceipt())
//                .photo(meal.getPhoto())
//                .build();

        return mealDTO;

    }
}
