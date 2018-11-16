package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.MealHasProduct;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryMealHasProduct;
import com.WildBirds.crudjpa.appliaction.implementations.CrudEntityJpa;
import com.WildBirds.crudjpa.appliaction.implementations.CrudJpa;

import javax.persistence.EntityManager;

public class RepositoryMealHasProductJPA extends CrudEntityJpa<MealHasProduct> implements RepositoryMealHasProduct {

    public RepositoryMealHasProductJPA(EntityManager entityManager) {
        super(MealHasProduct.class,entityManager);
    }

    public MealHasProduct someAdditionalMethod() {
        return null;
    }

}
