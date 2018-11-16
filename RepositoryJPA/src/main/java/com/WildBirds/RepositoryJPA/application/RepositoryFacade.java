package com.WildBirds.RepositoryJPA.application;

import com.WildBirds.RepositoryJPA.domain.ports.*;
import com.WildBirds.RepositoryJPA.domain.services.EntityManagerProvider;
import com.WildBirds.RepositoryJPA.infrastructure.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class RepositoryFacade {


    @EJB
    private EntityManagerProvider emp;

    public RepositoryCrud CRUD;
    public RepositoryMeal MEAL;
    public RepositoryMealHasProduct MEALHASPRODUCT;
    public RepositoryProduct PRODUCT;
    public RepositoryTypeMeal TYPEMEAL;

    public RepositoryFacade() {

        System.out.println("In construcotr");

        System.out.println(emp);
    }

    @PostConstruct
    public void init(){
        System.out.println(emp+" emp");
        System.out.println(this.CRUD +" crud");
        this.CRUD = new RepositoryCrudJPA(emp.getEntityManager());
        this.MEAL = new RepositoryMealJPA(emp.getEntityManager());
        this.MEALHASPRODUCT = new RepositoryMealHasProductJPA(emp.getEntityManager());
        this.PRODUCT = new RepositoryProductJPA(emp.getEntityManager());
        this.TYPEMEAL = new RepositoryTypeMealJPA(emp.getEntityManager());
    }

}
