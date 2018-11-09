package com.WildBirds.ReposiotryJPA.application;


import com.WildBirds.ReposiotryJPA.domain.model.TypeMeal;
import com.WildBirds.ReposiotryJPA.domain.services.EntityManagerFactoryService;
import com.WildBirds.ReposiotryJPA.infrastructure.RepositoryTypeMeal;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class RepositoryTypeMealFacade {

    public static RepositoryTypeMealFacade config() {
        EntityManagerFactoryService entityManagerFactoryService = new EntityManagerFactoryService();
        EntityManagerFactory entityManagerFactory = entityManagerFactoryService.getEntityManagerFactory();
        RepositoryTypeMeal repositoryTypeMeal = new RepositoryTypeMeal(entityManagerFactory);

        return new RepositoryTypeMealFacade(repositoryTypeMeal);
    }

    private RepositoryTypeMeal repositoryTypeMeal;

    private RepositoryTypeMealFacade(RepositoryTypeMeal repositoryTypeMeal) {
        this.repositoryTypeMeal = repositoryTypeMeal;
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
