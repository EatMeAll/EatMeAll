package com.WildBirds.ReposiotryJPA.application;


import com.WildBirds.ReposiotryJPA.domain.model.Language;
import com.WildBirds.ReposiotryJPA.domain.model.Meal;
import com.WildBirds.ReposiotryJPA.domain.ports.RepositoryMeal;
import com.WildBirds.ReposiotryJPA.domain.services.EntityManagerFactoryService;
import com.WildBirds.ReposiotryJPA.infrastructure.RepositoryMealJPA;
import com.WildBirds.crudjpa.appliaction.Crud;

import javax.persistence.EntityManagerFactory;
import java.util.List;


public class RepositoryMealFacade implements Crud<Meal>, RepositoryMeal {

    private RepositoryMealJPA repositoryMealJPA;

    public static RepositoryMealFacade config (){

        EntityManagerFactoryService entityManagerFactoryService = new EntityManagerFactoryService();
        EntityManagerFactory entityManagerFactory = entityManagerFactoryService.getEntityManagerFactory();
        RepositoryMealJPA repositoryMealJPA = new RepositoryMealJPA(entityManagerFactory);

        System.out.println("In RepositoryMealFacade config");

        return new RepositoryMealFacade(repositoryMealJPA);
    }

    private RepositoryMealFacade(RepositoryMealJPA repositoryMealJPA) {
        this.repositoryMealJPA = repositoryMealJPA;

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

    public boolean delete(int id) {
        return this.repositoryMealJPA.delete(id);
    }

    public boolean insert(Meal insertData) {
        return this.repositoryMealJPA.insert(insertData);
    }

    public boolean update(Meal updateData) {
        return this.repositoryMealJPA.update(updateData);
    }
}
