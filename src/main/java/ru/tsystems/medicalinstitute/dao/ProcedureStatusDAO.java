package ru.tsystems.medicalinstitute.dao;

import ru.tsystems.medicalinstitute.model.ProcedureStatusEntity;

import java.util.List;

public interface ProcedureStatusDAO extends AbstractDAO<ProcedureStatusEntity> {
    List<ProcedureStatusEntity> listProcedureStatuses();
    ProcedureStatusEntity getByName(String name);
}
