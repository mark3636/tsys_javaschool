package ru.tsystems.medicalinstitute.dao;

import ru.tsystems.medicalinstitute.model.PatientEntity;

import java.util.Date;
import java.util.List;

public interface PatientDAO extends AbstractDAO<PatientEntity> {
    List<PatientEntity> listPatients();
    List<PatientEntity> filterPatients(String surname, Date birthday, String medicalCaseNumber);
    PatientEntity getBySocialSecurityNumber(int socialSecurityNumber);
}
