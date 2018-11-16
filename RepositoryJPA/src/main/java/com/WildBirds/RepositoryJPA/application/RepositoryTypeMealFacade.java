package com.WildBirds.RepositoryJPA.application;


import com.WildBirds.RepositoryJPA.domain.model.TypeMeal;
import com.WildBirds.RepositoryJPA.domain.services.EntityManagerProvider;
import com.WildBirds.RepositoryJPA.infrastructure.RepositoryTypeMeal;

import javax.ejb.EJB;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class RepositoryTypeMealFacade {

    @EJB
    EntityManagerProvider emp;

    private RepositoryTypeMeal repositoryTypeMeal;

    public RepositoryTypeMealFacade() {
        this.repositoryTypeMeal = new RepositoryTypeMeal(emp.getEntityManager());
    }


    public TypeMeal someAdditionalLogic() {
        return null;
    }
}
