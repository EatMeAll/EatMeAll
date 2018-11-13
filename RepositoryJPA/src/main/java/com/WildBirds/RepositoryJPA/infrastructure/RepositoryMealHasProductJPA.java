package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.MealHasProduct;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryMealHasProduct;
import com.WildBirds.crudjpa.appliaction.CrudJpa;


import javax.persistence.EntityManagerFactory;

public class RepositoryMealHasProductJPA extends CrudJpa<MealHasProduct> implements RepositoryMealHasProduct {

    private EntityManagerFactory entityManagerFactory;

    public RepositoryMealHasProductJPA(EntityManagerFactory entityManagerFactory) {
        super(MealHasProduct.class,entityManagerFactory);
        this.entityManagerFactory = entityManagerFactory;
    }

    public MealHasProduct someAdditionalMethod() {
        return null;
    }

}
