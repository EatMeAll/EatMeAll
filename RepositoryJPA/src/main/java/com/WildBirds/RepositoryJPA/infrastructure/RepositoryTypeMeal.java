package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.TypeMeal;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryTypeOfMeal;
import com.WildBirds.crudjpa.appliaction.implementations.CrudJpa;

import javax.persistence.EntityManager;

public class RepositoryTypeMeal extends CrudJpa<TypeMeal> implements RepositoryTypeOfMeal {

    public RepositoryTypeMeal(EntityManager entityManager) {
        super(TypeMeal.class,entityManager);
    }


    public TypeMeal someAdditionalLogic() {
        return null;
    }
}
