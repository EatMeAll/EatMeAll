package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.model.Meal;
import com.WildBirds.EatMeAll.domain.ports.RepositoryMeal;
import com.WildBirds.EatMeAll.infrastructure.services.Mapper;
import com.WildBirds.RepositoryJPA.application.RepositoryMealFacade;
import com.WildBirds.crudjpa.appliaction.Crud;
import ma.glasnost.orika.MapperFacade;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class RepositoryMealAdapter implements Crud<Meal>, RepositoryMeal {

    @EJB
    private RepositoryMealFacade repositoryMealFacade;

    @EJB
    private Mapper mapper;

    @PostConstruct
    public void init() {
        this.mapper.register(Meal.class, com.WildBirds.RepositoryJPA.domain.model.Meal.class);
        this.mapper.register(com.WildBirds.RepositoryJPA.domain.model.Meal.class, Meal.class);
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
    public List<Meal> getAll(Integer skip, Integer limit) {
        return null;
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public Meal insert(Meal insertData) {
        MapperFacade facade = this.mapper.getFacade();
        return facade.map(
                this.repositoryMealFacade.insert(facade.map(
                        insertData,
                        com.WildBirds.RepositoryJPA.domain.model.Meal.class
                ))
                , Meal.class
        );
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
