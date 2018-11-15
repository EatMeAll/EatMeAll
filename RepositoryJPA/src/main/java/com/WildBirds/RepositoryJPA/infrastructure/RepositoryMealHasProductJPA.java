package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.MealHasProduct;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryMealHasProduct;
import com.WildBirds.crudjpa.appliaction.CrudJpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RepositoryMealHasProductJPA extends CrudJpa<MealHasProduct> implements RepositoryMealHasProduct {

    public RepositoryMealHasProductJPA(EntityManager entityManager) {
        super(MealHasProduct.class,entityManager);
    }

    public MealHasProduct someAdditionalMethod() {
        return null;
    }

}
