package com.WildBirds.RepositoryJPA.domain.ports;


import com.WildBirds.RepositoryJPA.domain.model.Product;
import com.WildBirds.RepositoryJPA.infrastructure.crudjpa.interfaces.CrudEntity;

public interface RepositoryProduct extends CrudEntity<Product> {
    Product someAdditionalLogic();
}
