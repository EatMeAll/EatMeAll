package com.WildBirds.ReposiotryJPA.infrastructure;


import com.WildBirds.ReposiotryJPA.domain.model.TypeMeal;
import com.WildBirds.ReposiotryJPA.domain.ports.RepositoryTypeOfMeal;
import com.WildBirds.ReposiotryJPA.domain.services.EntityManagerFactoryService;
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
