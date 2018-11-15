package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.model.Meal;
import com.WildBirds.EatMeAll.domain.ports.RepositoryCRUD;
import com.WildBirds.EatMeAll.domain.ports.RepositoryMeal;
import com.WildBirds.RepositoryJPA.application.RepositoryMealFacade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class RepositoryMealAdapter implements RepositoryCRUD<Meal>, RepositoryMeal {

    @EJB
    private RepositoryMealFacade repositoryMealFacade;

    public RepositoryMealAdapter() { }

    @Override
    public Meal get(int id) {
        return null;
    }

    @Override
    public List<Meal> getAll() {
        return null;
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public Meal insert(Meal insertData) {
        return null;
      // return this.repositoryMealFacade.insert(new com.WildBirds.RepositoryJPA.domain.model.Meal());
    }

    @Override
    public Meal update(Meal updateData) {
        return null;
    }

    @Override
    public Meal someAdditionalLogic() {
        return null;
    }


}
