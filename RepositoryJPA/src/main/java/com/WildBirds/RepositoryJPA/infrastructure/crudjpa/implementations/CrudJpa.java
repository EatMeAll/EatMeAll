package com.WildBirds.RepositoryJPA.infrastructure.crudjpa.implementations;

import com.WildBirds.RepositoryJPA.infrastructure.crudjpa.interfaces.Crud;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionScoped;
import java.util.List;


public class CrudJpa implements Crud {


    public CrudJpa() {}

    @PersistenceContext(unitName = "persistence-jpa")
    private EntityManager entityManager;

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
