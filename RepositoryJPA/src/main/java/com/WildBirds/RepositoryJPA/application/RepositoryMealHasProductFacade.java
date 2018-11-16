package com.WildBirds.RepositoryJPA.application;


import com.WildBirds.RepositoryJPA.domain.model.MealHasProduct;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryMealHasProduct;
import com.WildBirds.RepositoryJPA.domain.services.EntityManagerProvider;
import com.WildBirds.RepositoryJPA.infrastructure.RepositoryMealHasProductJPA;
import com.WildBirds.crudjpa.appliaction.interfaces.Crud;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
@Stateless
@LocalBean
public class RepositoryMealHasProductFacade implements Crud<MealHasProduct>, RepositoryMealHasProduct {

    @EJB
    EntityManagerProvider emp;

    private RepositoryMealHasProductJPA repositoryMealHasProductJPA;

    public RepositoryMealHasProductFacade() {
        this.repositoryMealHasProductJPA = new RepositoryMealHasProductJPA(emp.getEntityManager());
    }

    @Override
    public MealHasProduct someAdditionalMethod() {
        return null;
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


    public <Return> Return update(MealHasProduct updateData, Class<MealHasProduct> entityClass) {
        return null;
    }


    public <Return> Return insert(MealHasProduct insertData, Class<MealHasProduct> entityClass) {
        return null;
    }

    @Override
    public MealHasProduct update(MealHasProduct updateData) {
        return null;
    }

    @Override
    public MealHasProduct insert(MealHasProduct insertData) {
        return null;
    }
}
