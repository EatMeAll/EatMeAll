package com.WildBirds.RepositoryJPA.infrastructure;

import com.WildBirds.RepositoryJPA.domain.ports.RepositoryCrud;
import com.WildBirds.crudjpa.appliaction.implementations.CrudJpa;

import javax.persistence.EntityManager;

public class RepositoryCrudJPA extends CrudJpa implements RepositoryCrud {
    public RepositoryCrudJPA(EntityManager entityManager) {
        super(entityManager);
    }
}
