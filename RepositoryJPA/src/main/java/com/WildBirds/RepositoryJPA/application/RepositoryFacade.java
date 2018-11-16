package com.WildBirds.RepositoryJPA.application;

import com.WildBirds.RepositoryJPA.domain.ports.*;
import com.WildBirds.RepositoryJPA.domain.services.EntityManagerProvider;
import com.WildBirds.RepositoryJPA.infrastructure.*;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class RepositoryFacade {


    @EJB
    private EntityManagerProvider emp;

    public final RepositoryCrud CRUD = new RepositoryCrudJPA(emp.getEntityManager());
    public final RepositoryMeal MEAL = new RepositoryMealJPA(emp.getEntityManager());
    public final RepositoryMealHasProduct MEALHASPRODUCT = new RepositoryMealHasProductJPA(emp.getEntityManager());
    public final RepositoryProduct PRODUCT = new RepositoryProductJPA(emp.getEntityManager());
    public final RepositoryTypeMeal TYPEMEAL = new RepositoryTypeMealJPA(emp.getEntityManager());

}
