package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.model.Meal;
import com.WildBirds.RepositoryJPA.application.RepositoryMealFacade;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
@Local(RepositoryMealAdapterLocal.class)
public class RepositoryMealAdapter implements RepositoryMealAdapterLocal {
    // TODO: 13.11.2018 should implement mapper 
    @EJB
    private RepositoryMealFacade repositoryMealFacade;

    public RepositoryMealAdapter() {}

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
//       return this.repositoryMealFacade.insert(new com.WildBirds.RepositoryJPA.domain.model.Meal());
        return null;
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
