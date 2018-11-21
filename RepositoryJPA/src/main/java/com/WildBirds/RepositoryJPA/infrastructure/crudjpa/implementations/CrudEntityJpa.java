package com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.implementations;


import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.interfaces.CrudEntity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Stateless
public class CrudEntityJpa<Entity> implements CrudEntity<Entity> {


    @PersistenceContext(unitName = "persistence-jpa")
    protected EntityManager entityManager;

    private Class<Entity> entityClass;

    public CrudEntityJpa() {
    }

    public CrudEntityJpa(Class<Entity> entityClass) {
        this.entityClass = entityClass;

    }



    // Crud
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Entity get(int id) {
        return this.entityManager.find(this.entityClass, id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Entity> getIn(Integer... ids){
        List resultList = entityManager
                .createQuery("FROM "+this.entityClass.getSimpleName()+" IN :array", entityClass)
                .setParameter("array",ids)
                .getResultList();
        return resultList;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Entity> getAll() {

        List resultList = entityManager
                .createQuery("FROM "+this.entityClass.getSimpleName(), entityClass)
                .getResultList();

        return resultList;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Entity> getAll(Integer skip, Integer limit) {

        // TODO: 08.11.2018 should work but I'm not sure
        List resultList = entityManager
                .createQuery("FROM "+this.entityClass.getSimpleName())
                .setFirstResult(skip)
                .setMaxResults(limit)
                .getResultList();
        return resultList;
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
