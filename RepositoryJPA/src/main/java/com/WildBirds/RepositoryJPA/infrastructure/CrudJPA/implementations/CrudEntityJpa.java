package com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.implementations;

import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.interfaces.CrudEntity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.Collection;
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
        System.out.println(entityManager+ "-------------- GET -------------- EM");
        return this.entityManager.find(this.entityClass, id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Entity> getIn(Integer... ids){
        String simpleName = this.entityClass.getSimpleName();
        String query = "SELECT e FROM "+simpleName+" e WHERE e.id"+simpleName+" IN :array";
        System.out.println(query);


        List<Integer> ints = Arrays.asList(ids);
        List resultList = entityManager
                .createQuery(query, entityClass)
                .setParameter("array",ints)
                .getResultList();
        return resultList;
    }

    @Override
    public List<Entity> getIn(Collection<Integer> ids) {
        try {

            Integer[] integers = ids.stream().toArray(Integer[]::new);
            return this.getIn(integers);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("In get it");
        }

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
        System.out.println(entityManager+ "-------------- INSERT -------------- EM");
        entityManager.persist(insertData);
        System.out.println(entityManager+ "-------------- INSERT UPDATE -------------- EM");
        return entityManager.merge(insertData);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Entity update(Entity updateData) {
        System.out.println(entityManager+ "-------------- UPDATE -------------- EM");
        return entityManager.merge(updateData);
    }
}
