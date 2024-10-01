package ru.nikita.naujava.repositories;

import java.util.List;

public interface CrudRepository<T, ID> {
    void create(T entity);

    List<T> readAll();

    T read(ID id);

    void update(T entity);

    void delete(ID id);
}
