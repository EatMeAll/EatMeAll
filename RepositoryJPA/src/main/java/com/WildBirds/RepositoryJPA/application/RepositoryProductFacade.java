package com.WildBirds.RepositoryJPA.application;

import com.WildBirds.RepositoryJPA.domain.model.Product;
import com.WildBirds.RepositoryJPA.domain.services.EntityManagerProvider;
import com.WildBirds.RepositoryJPA.infrastructure.RepositoryProductJPA;

import javax.ejb.EJB;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class RepositoryProductFacade {

    @EJB
    EntityManagerProvider emp;


    private RepositoryProductJPA repositoryProductJPA;

    public RepositoryProductFacade() {
        this.repositoryProductJPA = new RepositoryProductJPA(emp.getEntityManager());
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
