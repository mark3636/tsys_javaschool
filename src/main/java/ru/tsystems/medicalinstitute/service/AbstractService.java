package ru.tsystems.medicalinstitute.service;

public interface AbstractService<T> {
    /**
     * Adds object
     * @param bo object, which should be added
     */
    void add(T bo);

    /**
     * Updates object
     * @param bo object, which should be updated
     */
    void update(T bo);

    /**
     * Returns object by its id
     * @param id object id
     * @return object
     */
    T getById(int id);

    /**
     * Removes object by its id
     * @param id object id
     */
    void remove(int id);
}
