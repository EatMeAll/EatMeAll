package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.model.TypeMeal;
import com.WildBirds.EatMeAll.domain.ports.RepositoryTypeMeal;
import com.WildBirds.RepositoryJPA.application.RepositoryTypeMealFacade;
import com.WildBirds.crudjpa.appliaction.Crud;

import javax.ejb.Stateless;
import java.util.List;


@Stateless
public class RepositoryTypeMealAdapter implements Crud<TypeMeal>, RepositoryTypeMeal {

    private RepositoryTypeMealFacade repositoryTypeOfMeal;

    public RepositoryTypeMealAdapter() {
        this.repositoryTypeOfMeal = new RepositoryTypeMealFacade();
    }

    @Override
    public TypeMeal get(int id) {
        return null;
    }

    @Override
    public List<TypeMeal> getAll() {
        return null;
    }

    @Override
    public List<TypeMeal> getAll(Integer skip, Integer limit) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public TypeMeal insert(TypeMeal insertData) {
        return null;
    }

    @Override
    public TypeMeal update(TypeMeal updateData) {
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
    public TypeMeal someAdditionalLogic() {
        return null;
    }
}
