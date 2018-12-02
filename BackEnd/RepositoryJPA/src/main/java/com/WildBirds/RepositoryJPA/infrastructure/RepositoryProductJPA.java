package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.Product;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryProduct;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.implementations.CrudEntityJpa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.time.Instant;
import java.util.Set;

@Stateless
@LocalBean
public class RepositoryProductJPA extends CrudEntityJpa<Product> implements RepositoryProduct {

    public RepositoryProductJPA() {
        super(Product.class);
    }

    public Product someAdditionalLogic() {
        return null;
    }

    @Override
    public Set<Product> getProductsList(Instant fromDate, Instant toDate, Integer idUser) {

        return null;
    }

    @Override
    public Product getProductByName(String name) {

        try {
            String query = "SELECT product FROM Product product WHERE product.name =: name";

            return this.entityManager.createQuery(query,Product.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }

    }
}
