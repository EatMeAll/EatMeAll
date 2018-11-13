package com.WildBirds.EatMeAll.domain.ports;

import java.util.List;

public interface RepositoryCRUD<T> {

    T get(int id);

    List<T> getAll();

    void delete(int id);

    T insert(T insertData);

    T update(T updateData);
}
