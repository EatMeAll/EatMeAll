package com.WildBirds.EatMeAll.domain.ports;

import java.util.List;

public interface RepositoryCRUD<T> {

    T get(int id);

    List<T> getAll();

    boolean delete(int id);

    boolean insert(T insertData);

    boolean update(T updateData);
}
