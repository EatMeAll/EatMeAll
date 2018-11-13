package com.WildBirds.crudjpa.appliaction;

import java.util.List;

public interface Crud<Entity> {

    Entity get(int id);

    List<Entity> getAll();

    List<Entity> getAll(Integer skip, Integer limit);

    boolean delete(int id);

    boolean insert(Entity insertData);

    boolean update(Entity updateData);
}
