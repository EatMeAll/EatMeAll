package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.TypeMeal;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryTypeMeal;
import com.WildBirds.RepositoryJPA.infrastructure.crudjpa.implementations.CrudEntityJpa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
@Stateless
@LocalBean
public class RepositoryTypeMealJPA extends CrudEntityJpa<TypeMeal> implements RepositoryTypeMeal {

    public RepositoryTypeMealJPA() {
        super(TypeMeal.class);
    }


    public TypeMeal someAdditionalLogic() {
        return null;
    }
}
