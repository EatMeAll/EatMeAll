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
        this.repositoryProductFacade = RepositoryProductFacade.config();
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
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean insert(Product insertData) {
        return false;
    }

    @Override
    public boolean update(Product updateData) {
        return false;
    }

    @Override
    public Product someAdditionalLogic() {
        return null;
    }
}
