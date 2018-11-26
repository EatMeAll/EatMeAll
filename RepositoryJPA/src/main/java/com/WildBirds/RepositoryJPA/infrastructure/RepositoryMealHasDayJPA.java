package com.WildBirds.RepositoryJPA.infrastructure;

import com.WildBirds.RepositoryJPA.domain.model.MealHasDay;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryMealHasDay;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.implementations.CrudEntityJpa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class RepositoryMealHasDayJPA extends CrudEntityJpa<MealHasDay> implements RepositoryMealHasDay {

    public RepositoryMealHasDayJPA() {
        super(MealHasDay.class);
    }


    @Override
    public MealHasDay addSomeAdditionalLogic() {
        return null;
    }
}
