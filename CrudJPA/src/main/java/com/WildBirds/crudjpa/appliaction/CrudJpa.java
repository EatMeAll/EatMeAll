package com.WildBirds.crudjpa.appliaction;

import com.WildBirds.crudjpa.domain.services.EntityManageFactory.EntityManagerFactoryService;

import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CrudJpa<Entity> implements Crud<Entity> {

    private Class<Entity> entityClass;
    private EntityManagerFactoryService entityManagerFactoryService;

    public CrudJpa(Class<Entity> entityClass, EntityManagerFactory entityManagerFactory) {
        this.entityClass = entityClass;
        this.entityManagerFactoryService = new EntityManagerFactoryService(entityManagerFactory);

    }


    @Override
    public Entity get(int id) {
        final AtomicReference<Entity> entity = new AtomicReference<>();
        this.entityManagerFactoryService.inTransaction(entityManager -> {
            entity.set(entityManager.find(this.entityClass, id));
        });
        return entity.get();
    }

    @Override
    public List<Entity> getAll() {


        // TODO: 08.11.2018 should work but I'm not sure
        AtomicReference<List<Entity>> resultList = null;
        this.entityManagerFactoryService.inTransaction(entityManager -> {

            resultList.set(entityManager
                    .createQuery("FROM :className")
                    .setParameter("className", this.entityClass.getSimpleName())
                    .getResultList());
        });

        return resultList.get();


    }

    @Override
    public List<Entity> getAll(Integer skip, Integer limit) {

        // TODO: 08.11.2018 should work but I'm not sure
        AtomicReference<List<Entity>> resultList = null;
        this.entityManagerFactoryService.inTransaction(entityManager -> {

            resultList.set(entityManager
                    .createQuery("FROM :className")
                    .setFirstResult(skip)
                    .setMaxResults(limit)
                    .setParameter("className", this.entityClass.getSimpleName())
                    .getResultList());
        });

        return resultList.get();

    }

    @Override
    public void delete(int id) {

        this.entityManagerFactoryService.inTransaction(entityManager -> {
            Entity entity = entityManager.find(this.entityClass, id);
            entityManager.remove(entity);
        });
    }

    @Override
    public Entity insert(Entity insertData) {
        this.entityManagerFactoryService.inTransaction(entityManager -> {
            entityManager.persist(insertData);
        });
        return insertData;
    }

    @Override
    public Entity update(Entity updateData) {
        this.entityManagerFactoryService.inTransaction(entityManager -> {
            entityManager.merge(updateData);
        });
        return updateData;
    }
}
