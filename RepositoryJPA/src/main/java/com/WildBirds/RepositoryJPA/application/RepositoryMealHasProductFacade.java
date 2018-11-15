package com.WildBirds.RepositoryJPA.application;


import com.WildBirds.RepositoryJPA.domain.model.TypeMeal;
import com.WildBirds.RepositoryJPA.domain.services.EntityManagerProvider;
import com.WildBirds.RepositoryJPA.infrastructure.RepositoryMealHasProductJPA;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import java.util.List;
@Stateless
@LocalBean
public class RepositoryMealHasProductFacade {

   // @EJB
    EntityManagerProvider emp;

    private RepositoryMealHasProductJPA repositoryMealHasProductJPA;

    public RepositoryMealHasProductFacade() {

        this.repositoryMealHasProductJPA = new RepositoryMealHasProductJPA(emp.getEntityManager());
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
