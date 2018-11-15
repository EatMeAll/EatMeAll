package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryMeal;
import com.WildBirds.crudjpa.appliaction.CrudJpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RepositoryMealJPA extends CrudJpa<Meal> implements RepositoryMeal {

    public RepositoryMealJPA(EntityManager entityManager) {
        super(Meal.class,entityManager);
    }

    public Meal someAdditionalLogic() {
        return null;
    }
}
