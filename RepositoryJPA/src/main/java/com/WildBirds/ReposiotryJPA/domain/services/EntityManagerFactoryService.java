package com.WildBirds.ReposiotryJPA.domain.services;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;


public class EntityManagerFactoryService {

    private EntityManagerFactory entityManagerFactory;


    public EntityManagerFactoryService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-jpa");
    }

    public EntityManagerFactory getEntityManagerFactory(){
        return this.entityManagerFactory;
    }
}