package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.ports.RepositoryMeal;
import com.WildBirds.EatMeAll.infrastructure.services.Mapper;
import com.WildBirds.RepositoryJPA.application.RepositoryMealFacade;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.crudjpa.appliaction.interfaces.Crud;
import ma.glasnost.orika.MapperFacade;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class RepositoryMealAdapter implements RepositoryMeal {


    @Override
    public Meal someAdditionalLogic() {
        return null;
    }
}
