package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.ports.RepositoryMealHasProduct;
import com.WildBirds.RepositoryJPA.application.RepositoryMealHasProductFacade;
import com.WildBirds.RepositoryJPA.domain.model.MealHasProduct;
import com.WildBirds.crudjpa.appliaction.interfaces.Crud;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class RepositoryMealHasProductAdapter implements RepositoryMealHasProduct {

    @Override
    public MealHasProduct someAdditionalMethod() {
        return null;
    }
}
