package ru.tsystems.medicalinstitute.dao;

import ru.tsystems.medicalinstitute.model.PatientEntity;

import java.util.List;

public interface PatientDAO extends AbstractDAO<PatientEntity> {
    List<PatientEntity> listPatients();
    PatientEntity getBySocialSecurityNumber(int socialSecurityNumber);
}
