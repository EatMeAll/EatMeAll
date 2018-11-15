package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.Product;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryProduct;
import com.WildBirds.crudjpa.appliaction.CrudJpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RepositoryProductJPA extends CrudJpa<Product> implements RepositoryProduct {

    public RepositoryProductJPA(EntityManager entityManager) {
        super(Product.class,entityManager);
    }

    public Product someAdditionalLogic() {
        return null;
    }
}
