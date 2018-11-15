package com.WildBirds.RepositoryJPA.application;


import com.WildBirds.RepositoryJPA.domain.model.Language;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryMeal;
import com.WildBirds.RepositoryJPA.domain.services.EntityManagerProvider;
import com.WildBirds.RepositoryJPA.infrastructure.RepositoryMealJPA;
import com.WildBirds.crudjpa.appliaction.Crud;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.annotation.PostConstruct;

@Stateless
@LocalBean
public class RepositoryMealFacade implements Crud<Meal>, RepositoryMeal {


//    @EJB
//    EntityManagerProvider emp;

    @PersistenceContext(unitName = "persistence-jpa")
    private EntityManager entityManager;

    private RepositoryMealJPA repositoryMealJPA;

    public RepositoryMealFacade() {


    }

    @PostConstruct
    public void init(){
        this.repositoryMealJPA = new RepositoryMealJPA(entityManager);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println( " INIT ");
        System.out.println("In RepositoryMealFacade Constructor");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

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

        if (entityManager == null) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("          NULLL  IN  INSERT           ");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }

        return this.repositoryMealJPA.insert(insertData);
    }

    public Meal update(Meal updateData) {
        return this.repositoryMealJPA.update(updateData);
    }
}
