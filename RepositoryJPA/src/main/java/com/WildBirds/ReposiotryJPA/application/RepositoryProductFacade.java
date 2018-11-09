package com.WildBirds.ReposiotryJPA.application;

import com.WildBirds.ReposiotryJPA.domain.model.Product;
import com.WildBirds.ReposiotryJPA.domain.services.EntityManagerFactoryService;
import com.WildBirds.ReposiotryJPA.infrastructure.RepositoryProductJPA;

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


        public boolean delete(int id) {
        return false;
    }


        public boolean insert(Product insertData) {
        return false;
    }


        public boolean update(Product updateData) {
        return false;
    }


        public Product someAdditionalLogic() {
        return null;
    }
}
