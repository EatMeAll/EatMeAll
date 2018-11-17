package com.WildBirds.RepositoryJPA.application;

import com.WildBirds.RepositoryJPA.domain.ports.*;
import com.WildBirds.RepositoryJPA.infrastructure.*;

import javax.annotation.PostConstruct;
import javax.ejb.*;

@Stateless
@LocalBean
public class RepositoryFacade {

    @EJB private RepositoryCrudJPA CRUD;
    @EJB private RepositoryMealJPA MEAL;
    @EJB private RepositoryMealHasProductJPA MEALHASPRODUCT;
    @EJB private RepositoryProductJPA PRODUCT;
    @EJB private RepositoryTypeMealJPA TYPEMEAL;

    public RepositoryFacade() {
        System.out.println("In construcotr");
    }

    public RepositoryMeal MEAL() {
        return this.MEAL;
    }

    public RepositoryProduct PRODUCT() {
        return this.PRODUCT;
    }

    public RepositoryMealHasProduct MEALHASPRODUCT() {
        return this.MEALHASPRODUCT;
    }
}
