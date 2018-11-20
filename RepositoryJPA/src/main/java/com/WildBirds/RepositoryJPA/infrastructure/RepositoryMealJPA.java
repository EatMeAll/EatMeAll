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
import java.io.File;
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
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Meal> getMealsByTypeMeal(MealTime mealTime, Language language, Integer amount) {
//        String query = "SELECT meal FROM Meal meal " +
//                "JOIN meal.typeMeal typeMeal " +
//                "WHERE typeMeal.idTypeMeal =: idMeal AND " +
//                "meal.language =: language " +
//                "ORDER BY RAND()";
//
//
//        return this.entityManager.createQuery(query,Meal.class)
//                .setParameter("idMeal", mealTime.getIndex())
//                .setParameter("language", language)
//                .setMaxResults(amount)
//                .getResultList();

        //todo WORKING WITHOUT PARAMETER
        String query = "SELECT * FROM Meal inner join MealHasTypeMeal ON Meal.idMeal = MealHasTypeMeal.idMeal inner join TypeMeal ON MealHasTypeMeal.idTypeMeal = TypeMeal.idTypeMeal WHERE TypeMeal.mealTime = 'DINNER' AND Meal.language = 'PL' ORDER BY rand() LIMIT 1";
        return this.entityManager.createNativeQuery(query,Meal.class)
//                .setParameter(1, mealTime.toString())
//                .setParameter(2, language)
//                .setParameter(3, amount)
                .getResultList();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Meal> getMealsByTypeMeal(MealTime mealTime, Language language) {

        String query = "SELECT meal FROM Meal meal " +
                "JOIN meal.typeMeal typeMeal " +
                " WHERE typeMeal.idTypeMeal= :idMeal" +
                " AND meal.language =: language ";


        return this.entityManager.createQuery(query,Meal.class)
                .setParameter("idMeal", mealTime.getIndex())
                .setParameter("language", language)
                .getResultList();


    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Meal> getMealsByTypeMeal(MealTime mealTime) {
        String query = "SELECT meal FROM Meal meal " +
                "JOIN meal.typeMeal typeMeal " +
                "WHERE typeMeal.idTypeMeal = :idMeal";

        return this.entityManager.createQuery(query, Meal.class).
                setParameter("idMeal", mealTime.getIndex()).
                getResultList();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public File getFile(int idPhoto) {
        String query ="SELECT meal.photo FROM Meal meal WHERE meal.idMeal=: idPhoto";

                return this.entityManager.createQuery(query, File.class)
                        .setParameter("idPhoto", idPhoto)
                        .getSingleResult();

    }


}
