package com.WildBirds.RepositoryJPA.application;

import com.WildBirds.RepositoryJPA.domain.ports.*;
import com.WildBirds.RepositoryJPA.infrastructure.*;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class RepositoryFacade {

    @EJB
    private RepositoryCrudJPA CRUD;
    @EJB
    private RepositoryDayJPA DAY;
    @EJB
    private RepositoryMealJPA MEAL;
    @EJB
    private RepositoryMealHasProductJPA MEALHASPRODUCT;
    @EJB
    private RepositoryProductJPA PRODUCT;
    @EJB
    private RepositoryReceiptJPA RECEIPT;
    @EJB
    private RepositoryStepJPA STEP;
    @EJB
    private RepositoryTypeMealJPA TYPEMEAL;
    @EJB
    private RepositoryUserJPA USER;


    public RepositoryFacade() {
        System.out.println("In construcotr");
    }

    public RepositoryDay DAY() {
        return this.DAY;
    }

    public RepositoryMeal MEAL() {
        return this.MEAL;
    }

    public RepositoryMealHasProduct MEALHASPRODUCT() {
        return this.MEALHASPRODUCT;
    }

    public RepositoryProduct PRODUCT() {
        return this.PRODUCT;
    }

    public RepositoryReceipt RECEIPT(){
        return this.RECEIPT;
    }

    public RepositoryStep STEP(){
        return this.STEP;
    }

    public RepositoryTypeMeal TYPEMEAL(){
        return this.TYPEMEAL;
    }

    public RepositoryUser USER() {
        return this.USER;
    }
}
