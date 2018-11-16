package com.WildBirds.crudjpa.appliaction;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import java.util.List;

public class CrudJpa<Entity> implements Crud<Entity> {

    private EntityManager entityManager;
    private Class<Entity> entityClass;

    public CrudJpa(Class<Entity> entityClass, EntityManager entityManager) {

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
        return this.insert(insertData, entityClass);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Entity update(Entity updateData) {
        return this.update(updateData, entityClass);
    }

    // All Entity
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <Return> Return get(int id, Class<Return> entityClass) {
        return entityManager.find(entityClass, id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <Return> List<Return> getAll(Class<Return> entityClass) {
        return entityManager
                .createQuery("FROM :className")
                .setParameter("className", entityClass.getSimpleName())
                .getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <Return> List<Return> getAll(Integer skip, Integer limit, Class<Return> entityClass) {
        // TODO: 08.11.2018 should work but I'm not sure
        return entityManager
                .createQuery("FROM :className")
                .setFirstResult(skip)
                .setMaxResults(limit)
                .setParameter("className", entityClass.getSimpleName())
                .getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <Return> void delete(int id, Class<Return> entityClass) {
        entityManager.remove(entityManager.find(entityClass, id));
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <Return> Return insert(Return insertData, Class<Return> entityClass) {
        entityManager.persist(insertData);
        return (Return) entityManager.merge(insertData);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <Return> Return update(Return updateData, Class<Return> entityClass) {
        return (Return) entityManager.merge(updateData);
    }




}
