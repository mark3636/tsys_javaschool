package ru.tsystems.medicalinstitute.service;

public interface AbstractService<T> {
    void add(T bo);
    void update(T bo);
    T getById(int id);
    void remove(int id);
}
