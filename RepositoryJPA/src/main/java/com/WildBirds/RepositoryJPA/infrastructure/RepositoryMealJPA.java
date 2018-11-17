package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryMeal;
import com.WildBirds.RepositoryJPA.infrastructure.crudjpa.implementations.CrudEntityJpa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
@Stateless
@LocalBean
public class RepositoryMealJPA extends CrudEntityJpa<Meal> implements RepositoryMeal {

    public RepositoryMealJPA() {
        super(Meal.class);
    }

    public Meal someAdditionalLogic() {
        return null;
    }


}
