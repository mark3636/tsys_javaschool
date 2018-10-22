package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.Visit;

import java.util.List;

public interface VisitService extends AbstractService<Visit> {
    List<Visit> listVisits();
}
