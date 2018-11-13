package com.WildBirds.crudjpa.appliaction;

import java.util.List;

public interface Crud<Entity> {

    Entity get(int id);

    List<Entity> getAll();

    List<Entity> getAll(Integer skip, Integer limit);

    void delete(int id);

    Entity insert(Entity insertData);

    Entity update(Entity updateData);
}
