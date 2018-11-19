package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryMeal;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.implementations.CrudEntityJpa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Stateless
@LocalBean
public class RepositoryMealJPA extends CrudEntityJpa<Meal> implements RepositoryMeal {


    public RepositoryMealJPA() {
        super(Meal.class);
    }

    public Meal someAdditionalLogic() {
        return null;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Meal> getMealsByMealTeam(MealTime mealTime) {
        String Query = "SELECT meal FROM Meal meal JOIN meal.typeMeal typeMeal WHERE typeMeal.idTypeMeal = :idMeal";
//        String Query1 = "FROM Meal";
        return this.entityManager.createQuery(Query, Meal.class).setParameter("idMeal", mealTime.getIndex()).getResultList();
//        return this.entityManager.createQuery(Query1, Meal.class).getResultList();
    }




}
