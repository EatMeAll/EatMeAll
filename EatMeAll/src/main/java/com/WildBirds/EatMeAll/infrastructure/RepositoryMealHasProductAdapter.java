package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.model.MealHasProduct;
import com.WildBirds.EatMeAll.domain.ports.RepositoryMealHasProduct;
import com.WildBirds.RepositoryJPA.application.RepositoryMealHasProductFacade;
import com.WildBirds.crudjpa.appliaction.Crud;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class RepositoryMealHasProductAdapter implements Crud<MealHasProduct>, RepositoryMealHasProduct {


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
    public List<MealHasProduct> getAll(Integer skip, Integer limit) {
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
    public <Return> Return get(int id, Class<Return> entityClass) {
        return null;
    }

    @Override
    public <Return> List<Return> getAll(Class<Return> entityClass) {
        return null;
    }

    @Override
    public <Return> List<Return> getAll(Integer skip, Integer limit, Class<Return> entityClass) {
        return null;
    }

    @Override
    public <Return> void delete(int id, Class<Return> entityClass) {

    }

    @Override
    public <Return> Return insert(Return insertData, Class<Return> entityClass) {
        return null;
    }

    @Override
    public <Return> Return update(Return updateData, Class<Return> entityClass) {
        return null;
    }

    @Override
    public MealHasProduct someAdditionalMethod() {
        return null;
    }
}
