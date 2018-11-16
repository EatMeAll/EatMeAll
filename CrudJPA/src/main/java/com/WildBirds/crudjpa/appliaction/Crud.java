package com.WildBirds.crudjpa.appliaction;

import java.util.List;

public interface Crud<Entity> {

    Entity get(int id);

    List<Entity> getAll();

    List<Entity> getAll(Integer skip, Integer limit);

    void delete(int id);

    Entity insert(Entity insertData);

    Entity update(Entity updateData);

    //All Entity

    <Return> Return get(int id, Class<Return> entityClass);

    <Return> List<Return> getAll(Class<Return> entityClass);

    <Return> List<Return> getAll(Integer skip, Integer limit, Class<Return> entityClass);

    <Return> void delete(int id, Class<Return> entityClass);

    <Return> Return insert(Return insertData, Class<Return> entityClass);

    <Return> Return update(Return updateData, Class<Return> entityClass);
}
