package com.WildBirds.crudjpa.appliaction;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

public class CrudJpa<Entity> implements Crud<Entity> {

    private EntityManager entityManager;
    private Class<Entity> entityClass;

    public CrudJpa(Class<Entity> entityClass,EntityManager entityManager) {

        System.out.println();
        System.out.println();
        System.out.println(" ENTITY MANGETER <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(entityManager);
        System.out.println();
        System.out.println();
        this.entityClass = entityClass;
        this.entityManager = entityManager;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Entity get(int id) {
        return entityManager.find(this.entityClass, id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Entity> getAll() {

        List className = entityManager
                .createQuery("FROM :className")
                .setParameter("className", this.entityClass.getSimpleName())
                .getResultList();

        return className;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Entity> getAll(Integer skip, Integer limit) {

        // TODO: 08.11.2018 should work but I'm not sure
        List className = entityManager
                .createQuery("FROM :className")
                .setFirstResult(skip)
                .setMaxResults(limit)
                .setParameter("className", this.entityClass.getSimpleName())
                .getResultList();
        return className;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(int id) {
          entityManager.remove(entityManager.find(entityClass,id));
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Entity insert(Entity insertData) {
        entityManager.persist(insertData);
        return insertData;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Entity update(Entity updateData) {
        return entityManager.merge(updateData);
    }
}
