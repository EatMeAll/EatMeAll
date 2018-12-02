package com.WildBirds.RepositoryJPA.domain.ports;


import com.WildBirds.RepositoryJPA.domain.model.Product;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.interfaces.CrudEntity;

import java.time.Instant;
import java.util.Set;

public interface RepositoryProduct extends CrudEntity<Product> {
    Product someAdditionalLogic();

    Set<Product> getProductsList(Instant fromDate, Instant toDate, Integer idUser);

    Product getProductByName(String name);
}
