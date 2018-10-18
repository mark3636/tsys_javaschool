package ru.tsystems.medicalinstitute.dao;

public interface AbstractDAO<T> {
    void add(T entity);
    void update(T entity);
    T getById(int id);
    void remove(int id);
}
