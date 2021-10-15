package by.itransition.service;

import java.util.List;

public interface BaseService<T> {
    T findById(int id);
    List<T> findAll();
    boolean deleteById(int id);
    boolean update(T entity);
    boolean save(T entity);
}
