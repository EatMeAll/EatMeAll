package com.WildBirds.RepositoryJPA.infrastructure.crudjpa.implementations;

import com.WildBirds.RepositoryJPA.infrastructure.crudjpa.interfaces.CrudEntity;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionScoped;
import java.util.List;


public class CrudEntityJpa<Entity> implements CrudEntity<Entity> {


    @PersistenceContext(unitName = "persistence-jpa")
    private EntityManager entityManager;

    private Class<Entity> entityClass;

    public CrudEntityJpa() {
    }

    public CrudEntityJpa(Class<Entity> entityClass) {
        this.entityClass = entityClass;

    }



    // Crud
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Entity get(int id) {
        return this.entityManager.find(this.entityClass, id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public List<Entity> getAll() {

        List className = entityManager
                .createQuery("FROM :className")
                .setParameter("className", this.entityClass.getSimpleName())
                .getResultList();

        return className;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
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

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void delete(int id) {
        entityManager.remove(entityManager.find(entityClass, id));
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Entity insert(Entity insertData) {
        entityManager.persist(insertData);
        return entityManager.merge(insertData);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Entity update(Entity updateData) {
        return entityManager.merge(updateData);
    }
}
