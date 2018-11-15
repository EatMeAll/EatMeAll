package com.WildBirds.RepositoryJPA.application;


import com.WildBirds.RepositoryJPA.domain.model.TypeMeal;
import com.WildBirds.RepositoryJPA.domain.services.EntityManagerProvider;
import com.WildBirds.RepositoryJPA.infrastructure.RepositoryTypeMeal;

import javax.ejb.EJB;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class RepositoryTypeMealFacade {

   // @EJB
    EntityManagerProvider emp;

    private RepositoryTypeMeal repositoryTypeMeal;

    public RepositoryTypeMealFacade() {
        this.repositoryTypeMeal = new RepositoryTypeMeal(emp.getEntityManager());
    }

    public TypeMeal get(int id) {
        return null;
    }

    public List<TypeMeal> getAll() {
        return null;
    }

    public boolean delete(int id) {
        return false;
    }

    public boolean insert(TypeMeal insertData) {
        return false;
    }

    public boolean update(TypeMeal updateData) {
        return false;
    }

    public TypeMeal someAdditionalLogic() {
        return null;
    }
}
