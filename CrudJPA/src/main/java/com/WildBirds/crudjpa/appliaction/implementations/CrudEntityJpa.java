package com.WildBirds.crudjpa.appliaction.implementations;

import com.WildBirds.crudjpa.appliaction.interfaces.CrudEntity;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class CrudEntityJpa<Entity> implements CrudEntity<Entity> {

    private EntityManager entityManager;
    private Class<Entity> entityClass;

    public CrudEntityJpa(Class<Entity> entityClass, EntityManager entityManager) {

        this.entityClass = entityClass;
        this.entityManager = entityManager;
    }

    // Crud
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
        entityManager.remove(entityManager.find(entityClass, id));
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Entity insert(Entity insertData) {
        entityManager.persist(insertData);
        return entityManager.merge(insertData);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Entity update(Entity updateData) {
        return entityManager.merge(updateData);
    }
}
