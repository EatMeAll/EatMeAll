package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.Product;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryProduct;
import com.WildBirds.RepositoryJPA.infrastructure.crudjpa.implementations.CrudEntityJpa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
@Stateless
@LocalBean
public class RepositoryProductJPA extends CrudEntityJpa<Product> implements RepositoryProduct {

    public RepositoryProductJPA() {
        super(Product.class);
    }

    public Product someAdditionalLogic() {
        return null;
    }
}
