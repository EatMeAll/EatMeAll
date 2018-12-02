package com.WildBirds.RepositoryJPA.domain.ports;

import com.WildBirds.RepositoryJPA.domain.model.MealHasDay;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.interfaces.CrudEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


public interface RepositoryMealHasDay extends CrudEntity<MealHasDay> {



    MealHasDay addSomeAdditionalLogic();
}
