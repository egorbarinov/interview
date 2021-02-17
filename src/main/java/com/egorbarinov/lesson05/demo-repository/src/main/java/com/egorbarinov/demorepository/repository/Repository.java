package com.egorbarinov.demorepository.repository;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Repository<T, ID extends Serializable>{

    T findById(Class<T> typeClass, ID id);
    void save(T entity);
    void delete(T entity);
    List<T> findAll();

//    Iterable<T> findAll();
//

}
