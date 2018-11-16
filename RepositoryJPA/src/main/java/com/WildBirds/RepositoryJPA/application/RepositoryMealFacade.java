package com.WildBirds.RepositoryJPA.application;


import com.WildBirds.RepositoryJPA.domain.model.enums.Language;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryMeal;
import com.WildBirds.RepositoryJPA.domain.services.EntityManagerProvider;
import com.WildBirds.RepositoryJPA.infrastructure.RepositoryMealJPA;
import com.WildBirds.crudjpa.appliaction.Crud;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class RepositoryMealFacade implements Crud<Meal>, RepositoryMeal {

    @EJB
    EntityManagerProvider emp;
    private RepositoryMealJPA repositoryMealJPA;

    @PostConstruct
    public void init(){
        this.repositoryMealJPA = new RepositoryMealJPA(emp.getEntityManager());

        Meal meal = new Meal();
        meal.setAmountCalories(250);
        meal.setAuthorReceipt("Igor");
        meal.setLanguage(Language.PL);
        meal.setTitle("XXXX");
        meal.setPublic(true);

        this.repositoryMealJPA.insert(meal);

    }

    @Override
    public Meal someAdditionalLogic() {
        return null;
    }

    @Override
    public Meal get(int id) {
        return null;
    }

    @Override
    public List<Meal> getAll() {
        return null;
    }

    @Override
    public List<Meal> getAll(Integer skip, Integer limit) {
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
    public <Return> Return update(Return updateData, Class<Return> entityClass) {
        return null;
    }

    @Override
    public <Return> Return insert(Return insertData, Class<Return> entityClass) {
        return null;
    }

    @Override
    public Meal update(Meal updateData) {
        return null;
    }

    @Override
    public Meal insert(Meal insertData) {
        return null;
    }
}
