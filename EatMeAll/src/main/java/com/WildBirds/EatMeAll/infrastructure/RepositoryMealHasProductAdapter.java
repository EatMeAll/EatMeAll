package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.model.MealHasProduct;
import com.WildBirds.EatMeAll.domain.ports.RepositoryCRUD;
import com.WildBirds.EatMeAll.domain.ports.RepositoryMealHasProduct;
import com.WildBirds.RepositoryJPA.application.RepositoryMealHasProductFacade;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class RepositoryMealHasProductAdapter implements RepositoryCRUD<MealHasProduct>, RepositoryMealHasProduct {


    private RepositoryMealHasProductFacade repositoryMealHasProductFacade;

    public RepositoryMealHasProductAdapter() {
        this.repositoryMealHasProductFacade = new RepositoryMealHasProductFacade();
    }


    @Override
    public MealHasProduct get(int id) {
        return null;
    }

    @Override
    public List<MealHasProduct> getAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public MealHasProduct insert(MealHasProduct insertData) {
        return null;
    }

    @Override
    public MealHasProduct update(MealHasProduct updateData) {
        return null;
    }

    @Override
    public MealHasProduct someAdditionalMethod() {
        return null;
    }
}
