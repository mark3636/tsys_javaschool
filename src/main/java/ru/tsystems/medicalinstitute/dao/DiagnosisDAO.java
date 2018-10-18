package ru.tsystems.medicalinstitute.dao;

import ru.tsystems.medicalinstitute.model.DiagnosisEntity;

import java.util.List;

public interface DiagnosisDAO extends AbstractDAO<DiagnosisEntity> {
    List<DiagnosisEntity> listDiagnoses();
}
