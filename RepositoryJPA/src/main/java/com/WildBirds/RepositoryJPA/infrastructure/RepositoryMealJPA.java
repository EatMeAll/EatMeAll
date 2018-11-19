package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;
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
    public List<Meal> getMealsByTypeMeal(MealTime mealTime, Language language, Integer amount, Boolean isPublic, List<String> listProducts) {
        return null;
    }

    @Override
    public List<Meal> getMealsByTypeMeal(MealTime mealTime, Language language, Integer amount, Boolean isPublic) {
        return null;
    }

    @Override
    public List<Meal> getMealsByTypeMeal(MealTime mealTime, Language language, Integer amount) {
        return null;
    }

    @Override
    public List<Meal> getMealsByTypeMeal(MealTime mealTime, Language language) {
        String query = "SELECT meal FROM Meal meal " +
                "JOIN meal.typeMeal typeMeal " +
                "JOIN meal.language language" +
                " WHERE typeMeal.idTypeMeal = :idMeal AND " +
                "language =: language ";


        return this.entityManager.createQuery(query,Meal.class)
                .setParameter("idMeal", mealTime.getIndex())
                .setParameter("language", language)
                .getResultList();

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Meal> getMealsByMealTeam(MealTime mealTime) {
        String query = "SELECT meal FROM Meal meal JOIN meal.typeMeal typeMeal WHERE typeMeal.idTypeMeal = :idMeal";

        return this.entityManager.createQuery(query, Meal.class).
                setParameter("idMeal", mealTime.getIndex()).
                getResultList();
    }


}
