package com.WildBirds.RepositoryJPA.application;


import com.WildBirds.RepositoryJPA.domain.model.Language;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryMeal;
import com.WildBirds.RepositoryJPA.domain.services.EntityManagerFactoryService;
import com.WildBirds.RepositoryJPA.infrastructure.RepositoryMealJPA;
import com.WildBirds.crudjpa.appliaction.Crud;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Stateless
@LocalBean
public class RepositoryMealFacade implements Crud<Meal>, RepositoryMeal {

    private RepositoryMealJPA repositoryMealJPA;

    public RepositoryMealFacade() {

        EntityManagerFactoryService entityManagerFactoryService = new EntityManagerFactoryService();
        EntityManagerFactory entityManagerFactory = entityManagerFactoryService.getEntityManagerFactory();
        this.repositoryMealJPA = new RepositoryMealJPA(entityManagerFactory);

        System.out.println("In RepositoryMealFacade Constructor");

        Meal meal = new Meal();
        meal.setAmountCalories(250);
        meal.setAuthorReceipt("Igor");
        meal.setDescription("xxxx");
        meal.setLanguage(Language.PL);
        meal.setPrepareTime(15);
        meal.setTitle("XXXX");

        this.repositoryMealJPA.insert(meal);
    }

    public Meal someAdditionalLogic() {
       return this.repositoryMealJPA.someAdditionalLogic();
    }

    public Meal get(int id) {
        return this.repositoryMealJPA.get(id);
    }

    public List<Meal> getAll() {
        return this.repositoryMealJPA.getAll();
    }

    public List<Meal> getAll(Integer skip, Integer limit) {
        return this.repositoryMealJPA.getAll(skip,limit);
    }

    public void delete(int id) {
        this.repositoryMealJPA.delete(id);
    }

    public Meal insert(Meal insertData) {
        return this.repositoryMealJPA.insert(insertData);
    }

    public Meal update(Meal updateData) {
        return this.repositoryMealJPA.update(updateData);
    }
}
