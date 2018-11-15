package com.WildBirds.EatMeAll.domain.ports;

import java.util.List;

public interface RepositoryCRUD<Entity> {

    Entity get(int id);

    List<Entity> getAll();

    void delete(int id);

    Entity insert(Entity insertData);

    Entity update(Entity updateData);
}
