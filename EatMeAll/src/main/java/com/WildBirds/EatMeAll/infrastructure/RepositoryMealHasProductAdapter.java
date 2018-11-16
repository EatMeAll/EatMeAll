package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.ports.RepositoryMealHasProduct;
import com.WildBirds.RepositoryJPA.domain.model.MealHasProduct;

import javax.ejb.Stateless;

@Stateless
public class RepositoryMealHasProductAdapter implements RepositoryMealHasProduct {

    @Override
    public MealHasProduct someAdditionalMethod() {
        return null;
    }
}
