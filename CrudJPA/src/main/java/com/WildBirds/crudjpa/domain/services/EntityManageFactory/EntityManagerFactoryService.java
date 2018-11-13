package com.WildBirds.crudjpa.domain.services.EntityManageFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerFactoryService {

    private EntityManagerFactory entityManagerFactory;

    public EntityManagerFactoryService(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void inTransaction(TransactionalMethod method){
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        method.exec(entityManager);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
