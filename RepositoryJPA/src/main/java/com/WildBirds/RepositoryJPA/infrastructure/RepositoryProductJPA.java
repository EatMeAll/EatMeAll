package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.Product;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryProduct;
import com.WildBirds.crudjpa.appliaction.implementations.CrudJpa;

import javax.persistence.EntityManager;

public class RepositoryProductJPA extends CrudJpa<Product> implements RepositoryProduct {

    public RepositoryProductJPA(EntityManager entityManager) {
        super(Product.class,entityManager);
    }

    public Product someAdditionalLogic() {
        return null;
    }
}
