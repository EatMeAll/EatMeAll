package com.WildBirds.RepositoryJPA.domain.ports;


import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.MealHasProduct;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.interfaces.CrudEntity;

import java.time.Instant;
import java.util.List;

public interface RepositoryMealHasProduct extends CrudEntity<MealHasProduct> {
    MealHasProduct someAdditionalMethod();

    List<MealHasProduct> getProductsList(List<Meal> mealList);

}
