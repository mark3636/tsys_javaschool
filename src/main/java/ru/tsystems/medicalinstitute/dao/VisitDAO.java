package ru.tsystems.medicalinstitute.dao;

import ru.tsystems.medicalinstitute.model.VisitEntity;

import java.util.List;

public interface VisitDAO extends AbstractDAO<VisitEntity> {
    List<VisitEntity> listVisits();
}
