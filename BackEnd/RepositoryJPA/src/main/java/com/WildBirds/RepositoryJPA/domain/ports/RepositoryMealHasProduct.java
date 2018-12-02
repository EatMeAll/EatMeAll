package com.WildBirds.RepositoryJPA.domain.ports;


import com.WildBirds.RepositoryJPA.domain.model.MealHasProduct;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.interfaces.CrudEntity;

public interface RepositoryMealHasProduct extends CrudEntity<MealHasProduct> {
    MealHasProduct someAdditionalMethod();

}
