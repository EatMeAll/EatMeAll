package com.WildBirds.RepositoryJPA.infrastructure.crudjpa.interfaces;

import java.util.List;

public interface Crud {

    <Return> Return get(int id, Class<Return> entityClass);

    <Return> List<Return> getAll(Class<Return> entityClass);

    <Return> List<Return> getAll(Integer skip, Integer limit, Class<Return> entityClass);

    <Return> void delete(int id, Class<Return> entityClass);

    <Return> Return insert(Return insertData, Class<Return> entityClass);

    <Return> Return update(Return updateData, Class<Return> entityClass);
}
