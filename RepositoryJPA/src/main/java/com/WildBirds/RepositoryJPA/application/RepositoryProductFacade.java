package com.WildBirds.RepositoryJPA.application;

import com.WildBirds.RepositoryJPA.domain.model.Product;
import com.WildBirds.RepositoryJPA.domain.services.EntityManagerFactoryService;
import com.WildBirds.RepositoryJPA.infrastructure.RepositoryProductJPA;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class RepositoryProductFacade {

    public static RepositoryProductFacade config(){
        EntityManagerFactoryService entityManagerFactoryService = new EntityManagerFactoryService();
        EntityManagerFactory entityManagerFactory = entityManagerFactoryService.getEntityManagerFactory();
        RepositoryProductJPA repositoryProductJPA = new RepositoryProductJPA(entityManagerFactory);
        return new RepositoryProductFacade(repositoryProductJPA);
    }


    private RepositoryProductJPA repositoryProductJPA;

    private RepositoryProductFacade(RepositoryProductJPA repositoryProductJPA) {
        this.repositoryProductJPA = repositoryProductJPA;
    }


        public Product get(int id) {
        return null;
    }


        public List<Product> getAll() {
        return null;
    }


        public void delete(int id) {

    }


        public Product insert(Product insertData) {
        return null;
    }


        public Product update(Product updateData) {
        return null;
    }


        public Product someAdditionalLogic() {
        return null;
    }
}
