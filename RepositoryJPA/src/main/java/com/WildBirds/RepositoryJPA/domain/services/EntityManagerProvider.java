package com.WildBirds.RepositoryJPA.domain.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class EntityManagerProvider {

    @PersistenceContext(unitName = "persistence-jpa")
    private EntityManager entityManager;

//    @PersistenceContext(unitName = "persistence-jpa")
//    private EntityManagerFactory entityManagerFactory;

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
