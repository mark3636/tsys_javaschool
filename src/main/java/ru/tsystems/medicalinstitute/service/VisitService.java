package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.Visit;

import java.util.List;

public interface VisitService extends AbstractService<Visit> {
    /**
     * Lists all visits
     * @return List of visits
     */
    List<Visit> listVisits();

    /**
     * Returns visits by patient
     * @param id patient id
     * @return List of visits
     */
    List<Visit> getByPatientId(int id);
}
