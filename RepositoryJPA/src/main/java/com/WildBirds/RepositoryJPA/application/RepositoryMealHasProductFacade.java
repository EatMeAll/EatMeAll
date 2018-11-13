package com.WildBirds.RepositoryJPA.application;


import com.WildBirds.RepositoryJPA.domain.model.TypeMeal;
import com.WildBirds.RepositoryJPA.infrastructure.RepositoryMealHasProductJPA;
import com.WildBirds.RepositoryJPA.domain.services.EntityManagerFactoryService;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class RepositoryMealHasProductFacade {

    public static RepositoryMealHasProductFacade config(){

        EntityManagerFactoryService entityManagerFactoryService = new EntityManagerFactoryService();
        EntityManagerFactory entityManagerFactory = entityManagerFactoryService.getEntityManagerFactory();
        RepositoryMealHasProductJPA repositoryMealHasProductJPA = new RepositoryMealHasProductJPA(entityManagerFactory);

        return new RepositoryMealHasProductFacade(repositoryMealHasProductJPA);
    }

    private RepositoryMealHasProductJPA repositoryMealHasProductJPA;

    private RepositoryMealHasProductFacade(RepositoryMealHasProductJPA repositoryMealHasProductJPA) {
        this.repositoryMealHasProductJPA = repositoryMealHasProductJPA;
    }

    public TypeMeal get(int id) {
        return null;
    }

    public List<TypeMeal> getAll() {
        return null;
    }

    public void delete(int id) {
    }

    public TypeMeal insert(TypeMeal insertData) {
        return null;
    }

    public TypeMeal update(TypeMeal updateData) {
        return null;
    }

    public TypeMeal someAdditionalLogic() {
        return null;
    }
}
