package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.model.TypeMeal;
import com.WildBirds.EatMeAll.domain.ports.RepositoryCRUD;
import com.WildBirds.EatMeAll.domain.ports.RepositoryTypeMeal;
import com.WildBirds.ReposiotryJPA.application.RepositoryTypeMealFacade;

import javax.ejb.Stateless;
import java.util.List;


@Stateless
public class RepositoryTypeMealAdapter implements RepositoryCRUD<TypeMeal>, RepositoryTypeMeal {


    private RepositoryTypeMealFacade repositoryTypeOfMeal;


    public RepositoryTypeMealAdapter() {
        this.repositoryTypeOfMeal = RepositoryTypeMealFacade.config();
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
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean insert(TypeMeal insertData) {
        return false;
    }

    @Override
    public boolean update(TypeMeal updateData) {
        return false;
    }

    @Override
    public TypeMeal someAdditionalLogic() {
        return null;
    }
}
