package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.TypeMeal;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryTypeMeal;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.implementations.CrudEntityJpa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
@LocalBean
public class RepositoryTypeMealJPA extends CrudEntityJpa<TypeMeal> implements RepositoryTypeMeal {

    public RepositoryTypeMealJPA() {
        super(TypeMeal.class);
    }


    @Override
    public TypeMeal findByMealTime(MealTime mealTime) {
        String query = "FROM TypeMeal tm WHERE tm.mealTime = :mealTime";
        try{
            return this.entityManager.createQuery(query, TypeMeal.class).setParameter("mealTime", mealTime).getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }
}
