package com.WildBirds.RepositoryJPA.domain.ports;


import com.WildBirds.RepositoryJPA.domain.model.TypeMeal;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.interfaces.CrudEntity;

public interface RepositoryTypeMeal extends CrudEntity<TypeMeal> {
    TypeMeal someAdditionalLogic();
}
