package com.WildBirds.crudjpa.domain.services.EntityManageFactory;

import javax.persistence.EntityManager;

@FunctionalInterface
public interface TransactionalMethod {
    public void exec(EntityManager entityManager);
}
