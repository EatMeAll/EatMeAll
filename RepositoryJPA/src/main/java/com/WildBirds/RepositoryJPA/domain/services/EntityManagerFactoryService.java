package com.WildBirds.RepositoryJPA.domain.services;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerFactoryService {

    private EntityManagerFactory entityManagerFactory;


    public EntityManagerFactoryService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-jpa");
    }

    public EntityManagerFactory getEntityManagerFactory(){
        return this.entityManagerFactory;
    }
}