package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryMeal;
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
