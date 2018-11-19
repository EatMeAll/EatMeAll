package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.MealHasProduct;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryMealHasProduct;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.implementations.CrudEntityJpa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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

}
