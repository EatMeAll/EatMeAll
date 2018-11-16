package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.model.Product;
import com.WildBirds.EatMeAll.domain.ports.RepositoryProduct;
import com.WildBirds.RepositoryJPA.application.RepositoryProductFacade;
import com.WildBirds.crudjpa.appliaction.Crud;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class RepositoryProductAdapter implements Crud<Product>, RepositoryProduct {

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
    public List<Product> getAll(Integer skip, Integer limit) {
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
    public <Return> Return get(int id, Class<Return> entityClass) {
        return null;
    }

    @Override
    public <Return> List<Return> getAll(Class<Return> entityClass) {
        return null;
    }

    @Override
    public <Return> List<Return> getAll(Integer skip, Integer limit, Class<Return> entityClass) {
        return null;
    }

    @Override
    public <Return> void delete(int id, Class<Return> entityClass) {

    }

    @Override
    public <Return> Return insert(Return insertData, Class<Return> entityClass) {
        return null;
    }

    @Override
    public <Return> Return update(Return updateData, Class<Return> entityClass) {
        return null;
    }

    @Override
    public Product someAdditionalLogic() {
        return null;
    }
}
