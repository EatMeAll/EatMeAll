package com.WildBirds.ReposiotryJPA.infrastructure;


import com.WildBirds.ReposiotryJPA.domain.model.Product;
import com.WildBirds.ReposiotryJPA.domain.ports.RepositoryProduct;
import com.WildBirds.ReposiotryJPA.domain.services.EntityManagerFactoryService;
import com.WildBirds.crudjpa.appliaction.CrudJpa;

import javax.persistence.EntityManagerFactory;

public class RepositoryProductJPA extends CrudJpa<Product> implements RepositoryProduct {

    private EntityManagerFactory entityManagerFactory;

    public RepositoryProductJPA(EntityManagerFactory entityManagerFactory) {
        super(Product.class,entityManagerFactory);
        this.entityManagerFactory = entityManagerFactory;

    }

    public Product someAdditionalLogic() {
        return null;
    }
}
