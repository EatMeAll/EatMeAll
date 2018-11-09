package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.model.MealHasProduct;
import com.WildBirds.EatMeAll.domain.ports.RepositoryCRUD;
import com.WildBirds.EatMeAll.domain.ports.RepositoryMealHasProduct;
import com.WildBirds.ReposiotryJPA.application.RepositoryMealHasProductFacade;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class RepositoryMealHasProductAdapter implements RepositoryCRUD<MealHasProduct>, RepositoryMealHasProduct {


    private RepositoryMealHasProductFacade repositoryMealHasProductFacade;

    public RepositoryMealHasProductAdapter() {
        this.repositoryMealHasProductFacade = RepositoryMealHasProductFacade.config();
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
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean insert(MealHasProduct insertData) {
        return false;
    }

    @Override
    public boolean update(MealHasProduct updateData) {
        return false;
    }

    @Override
    public MealHasProduct someAdditionalMethod() {
        return null;
    }
}
