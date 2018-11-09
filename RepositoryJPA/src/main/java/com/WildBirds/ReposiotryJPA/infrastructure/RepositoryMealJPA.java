package com.WildBirds.ReposiotryJPA.infrastructure;


import com.WildBirds.ReposiotryJPA.domain.model.Meal;
import com.WildBirds.ReposiotryJPA.domain.ports.RepositoryMeal;
import com.WildBirds.ReposiotryJPA.domain.services.EntityManagerFactoryService;
import com.WildBirds.crudjpa.appliaction.CrudJpa;

import javax.persistence.EntityManagerFactory;

public class RepositoryMealJPA extends CrudJpa<Meal> implements RepositoryMeal {

    private EntityManagerFactory entityManagerFactory;

    public RepositoryMealJPA(EntityManagerFactory entityManagerFactory) {
        super(Meal.class,entityManagerFactory);
        this.entityManagerFactory = entityManagerFactory;

    }

    public Meal someAdditionalLogic() {
        return null;
    }
}
