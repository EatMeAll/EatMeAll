package com.WildBirds.RepositoryJPA.application;


import com.WildBirds.RepositoryJPA.domain.model.TypeMeal;
import com.WildBirds.RepositoryJPA.domain.services.EntityManagerFactoryService;
import com.WildBirds.RepositoryJPA.infrastructure.RepositoryTypeMeal;

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
