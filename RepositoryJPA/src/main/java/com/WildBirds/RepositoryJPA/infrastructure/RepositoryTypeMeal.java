package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.TypeMeal;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryTypeOfMeal;
import com.WildBirds.crudjpa.appliaction.CrudJpa;

import javax.persistence.EntityManagerFactory;

public class RepositoryTypeMeal extends CrudJpa<TypeMeal> implements RepositoryTypeOfMeal {

    private EntityManagerFactory entityManagerFactory;

    public RepositoryTypeMeal(EntityManagerFactory entityManagerFactory) {
        super(TypeMeal.class,entityManagerFactory);
        this.entityManagerFactory = entityManagerFactory;

    }


    public TypeMeal someAdditionalLogic() {
        return null;
    }
}
