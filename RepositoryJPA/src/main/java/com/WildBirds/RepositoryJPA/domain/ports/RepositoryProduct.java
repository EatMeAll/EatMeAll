package com.WildBirds.RepositoryJPA.domain.ports;


import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.Product;
import com.WildBirds.crudjpa.appliaction.interfaces.CrudEntity;

public interface RepositoryProduct extends CrudEntity<Product> {
    Product someAdditionalLogic();
}
