package com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.interfaces;

import java.util.Collection;
import java.util.List;

public interface CrudEntity<Entity> {

    Entity get(int id);

    List<Entity> getIn(Integer... ids);

    List<Entity> getIn(Collection<Integer> ids);

    List<Entity> getAll();

    List<Entity> getAll(Integer skip, Integer limit);

    void delete(int id);

    Entity insert(Entity insertData);

    Entity update(Entity updateData);
}
