package com.WildBirds.EatMeAll.application.service;


import com.WildBirds.EatMeAll.application.modelDTO.MealDTO;
import com.WildBirds.RepositoryJPA.domain.model.Meal;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class MapperMealImpl implements MapperMeal{



    @Override
    public List<Meal> listMealDTOtoMeal(List<MealDTO> mealDTOList) {
        return null;
    }

    @Override
    public List<MealDTO> listMealtoMealDTO(List<Meal> mealList) {
        return null;
    }
}
