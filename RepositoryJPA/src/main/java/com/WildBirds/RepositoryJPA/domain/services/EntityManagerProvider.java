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

    public EntityManagerProvider() {

        System.out.println();
        System.out.println();
        System.out.println("Provider");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public void test(){}

//    @PersistenceContext(unitName = "persistence-jpa")
//    private EntityManagerFactory entityManagerFactory;

    public EntityManager getEntityManager() {

//        entityManagerFactory.getCache();

        return entityManager;
    }
}
