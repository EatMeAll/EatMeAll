package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.model.Product;
import com.WildBirds.EatMeAll.domain.ports.RepositoryCRUD;
import com.WildBirds.EatMeAll.domain.ports.RepositoryProduct;
import com.WildBirds.RepositoryJPA.application.RepositoryProductFacade;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class RepositoryProductAdapter implements RepositoryCRUD<Product>, RepositoryProduct {

    private RepositoryProductFacade repositoryProductFacade;

    public RepositoryProductAdapter() {
        this.repositoryProductFacade = new RepositoryProductFacade();
    }

    @Override
    public Product get(int id) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Product insert(Product insertData) {
        return null;
    }

    @Override
    public Product update(Product updateData) {
        return null;
    }

    @Override
    public Product someAdditionalLogic() {
        return null;
    }
}
