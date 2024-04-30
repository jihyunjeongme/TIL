package com.example.demo.db;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T, ID> extends Repository<T, ID> {

    // create, update
    T save(T date);

    // read
    Optional<T> findById(ID id);

    List<T> findAll();

    // delete
    void delete(ID id);

    // read
    Optional<T> indById(ID id);
}
