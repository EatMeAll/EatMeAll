package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.model.Meal;
import com.WildBirds.ReposiotryJPA.application.RepositoryMealFacade;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@Local(RepositoryMealAdapterLocal.class)
public class RepositoryMealAdapter implements RepositoryMealAdapterLocal {

    private RepositoryMealFacade repositoryMealFacade;

    public RepositoryMealAdapter() {
        this.repositoryMealFacade = RepositoryMealFacade.config();
    }

    @Override
    public Meal get(int id) {
        return null;
    }

    @Override
    public List<Meal> getAll() {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean insert(Meal insertData) {
       return this.repositoryMealFacade.insert(new com.WildBirds.ReposiotryJPA.domain.model.Meal());
    }

    @Override
    public boolean update(Meal updateData) {
        return false;
    }

    @Override
    public Meal someAdditionalLogic() {
        return null;
    }


}
