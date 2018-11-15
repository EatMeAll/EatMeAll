package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.model.TypeMeal;
import com.WildBirds.EatMeAll.domain.ports.RepositoryCRUD;
import com.WildBirds.EatMeAll.domain.ports.RepositoryTypeMeal;
import com.WildBirds.RepositoryJPA.application.RepositoryTypeMealFacade;

import javax.ejb.Stateless;
import java.util.List;


@Stateless
public class RepositoryTypeMealAdapter implements RepositoryCRUD<TypeMeal>, RepositoryTypeMeal {

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
    public TypeMeal someAdditionalLogic() {
        return null;
    }
}
