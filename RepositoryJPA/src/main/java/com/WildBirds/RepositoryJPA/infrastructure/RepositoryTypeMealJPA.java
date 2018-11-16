package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.TypeMeal;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryTypeMeal;
import com.WildBirds.crudjpa.appliaction.implementations.CrudEntityJpa;

import javax.persistence.EntityManager;

public class RepositoryTypeMealJPA extends CrudEntityJpa<TypeMeal> implements RepositoryTypeMeal {

    public RepositoryTypeMealJPA(EntityManager entityManager) {
        super(TypeMeal.class,entityManager);
    }


    public TypeMeal someAdditionalLogic() {
        return null;
    }
}
