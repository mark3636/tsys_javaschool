package ru.tsystems.medicalinstitute.service;

import java.util.List;

public interface AbstractService<T> {
    void add(T bo);
    void update(T bo);
    T getById(int id);
    void remove(int id);
}
