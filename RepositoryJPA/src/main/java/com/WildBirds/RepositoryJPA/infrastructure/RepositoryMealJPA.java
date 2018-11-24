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
import java.io.File;
import java.util.ArrayList;
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

        String query = "SELECT * FROM Meal inner join MealHasTypeMeal ON Meal.idMeal = MealHasTypeMeal.idMeal inner join TypeMeal ON MealHasTypeMeal.idTypeMeal = TypeMeal.idTypeMeal WHERE TypeMeal.mealTime = ?1 AND Meal.language = ?2 ORDER BY rand() LIMIT ?3";
        return this.entityManager.createNativeQuery(query,Meal.class)
                .setParameter(1, mealTime.toString())
                .setParameter(2, language)
                .setParameter(3, amount)
                .getResultList();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Meal> getMealsByTypeMeal(MealTime mealTime, Language language) {

        String query = "SELECT meal FROM Meal meal " +
                "JOIN meal.typeMealSet typeMeal " +
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
                "JOIN meal.typeMealSet typeMeal " +
                "WHERE typeMeal.mealTime = :idMeal";

        return this.entityManager.createQuery(query, Meal.class).
                setParameter("idMeal", mealTime).
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

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Meal> getShortMealByTypeMeal(MealTime mealTime, Language language, Integer amount) {

        String query = "SELECT Meal.idMeal, Meal.language, Meal.title, Meal.shortDescription, Meal.isPublic FROM Meal inner join MealHasTypeMeal ON Meal.idMeal = MealHasTypeMeal.idMeal inner join TypeMeal ON MealHasTypeMeal.idTypeMeal = TypeMeal.idTypeMeal WHERE TypeMeal.mealTime = ?1 AND Meal.language = ?2 ORDER BY rand() LIMIT ?3";

       List resultList = this.entityManager.createNativeQuery(query)
                .setParameter(1, mealTime.name())
                .setParameter(2, language.name())
                .setParameter(3, amount)
                .getResultList();

        List<Meal> mealList = new ArrayList<>();

        for (Object object : resultList) {
            Meal meal = new Meal();

            Object[] rowEntity = (Object[]) object;

            Integer idMeal = (Integer) rowEntity[0];
            meal.setIdMeal(idMeal);

            String lang = (String) rowEntity[1];
            meal.setLanguage(Language.valueOf(lang));

            String title = (String) rowEntity[2];
            meal.setTitle(title);

            String shortDescription = (String) rowEntity[3];
            meal.setShortDescription(shortDescription);

            Boolean isPublic = (Boolean) rowEntity[4];
            meal.setPublic(isPublic);

            mealList.add(meal);
        }
        return mealList;

    }

}
