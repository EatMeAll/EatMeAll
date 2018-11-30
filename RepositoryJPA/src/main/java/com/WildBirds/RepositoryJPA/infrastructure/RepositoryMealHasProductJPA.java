package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.MealHasProduct;
import com.WildBirds.RepositoryJPA.domain.model.Product;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryMealHasProduct;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.implementations.CrudEntityJpa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.time.Instant;
import java.util.List;
import java.util.Set;

@Stateless
@LocalBean
public class RepositoryMealHasProductJPA extends CrudEntityJpa<MealHasProduct> implements RepositoryMealHasProduct {

    public RepositoryMealHasProductJPA() {
        super(MealHasProduct.class);
    }

    @Override
    public MealHasProduct someAdditionalMethod() {
        return null;
    }


    @Override
    public List<MealHasProduct> getProductsList(Instant fromDate, Instant toDate, List<Meal> mealList) {


        System.out.println(fromDate);
        System.out.println(toDate);



        String query = "SELECT mealHasProduct FROM MealHasProduct mealHasProduct " +
                "WHERE mealHasProduct.meal IN (:idMeals)";

        return this.entityManager.createQuery(query, MealHasProduct.class)
                .setParameter("idMeals", mealList)
                .getResultList();

    }

}
