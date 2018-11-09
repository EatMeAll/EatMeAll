package com.WildBirds.ReposiotryJPA.application;


import com.WildBirds.ReposiotryJPA.domain.model.TypeMeal;
import com.WildBirds.ReposiotryJPA.infrastructure.RepositoryMealHasProductJPA;
import com.WildBirds.ReposiotryJPA.domain.services.EntityManagerFactoryService;

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
