package ru.tsystems.medicalinstitute.dao;

import ru.tsystems.medicalinstitute.model.CaseStatusEntity;

import java.util.List;

public interface CaseStatusDAO extends AbstractDAO<CaseStatusEntity> {
    List<CaseStatusEntity> listCaseStatuses();
    CaseStatusEntity getByName(String name);
}
