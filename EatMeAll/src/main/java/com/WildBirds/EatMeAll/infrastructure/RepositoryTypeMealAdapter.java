package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.ports.RepositoryTypeMeal;
import com.WildBirds.RepositoryJPA.application.RepositoryTypeMealFacade;
import com.WildBirds.RepositoryJPA.domain.model.TypeMeal;
import com.WildBirds.crudjpa.appliaction.interfaces.Crud;

import javax.ejb.Stateless;
import java.util.List;


@Stateless
public class RepositoryTypeMealAdapter implements RepositoryTypeMeal {


    @Override
    public TypeMeal someAdditionalLogic() {
        return null;
    }
}
