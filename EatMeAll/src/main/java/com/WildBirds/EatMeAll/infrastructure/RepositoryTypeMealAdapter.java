package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.ports.RepositoryTypeMeal;
import com.WildBirds.RepositoryJPA.domain.model.TypeMeal;

import javax.ejb.Stateless;


@Stateless
public class RepositoryTypeMealAdapter implements RepositoryTypeMeal {


    @Override
    public TypeMeal someAdditionalLogic() {
        return null;
    }
}
