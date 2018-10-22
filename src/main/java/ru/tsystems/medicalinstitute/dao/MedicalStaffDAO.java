package ru.tsystems.medicalinstitute.dao;

import ru.tsystems.medicalinstitute.model.MedicalStaffEntity;

import java.util.List;

public interface MedicalStaffDAO extends AbstractDAO<MedicalStaffEntity> {
    List<MedicalStaffEntity> listMedicalStaff();
    MedicalStaffEntity findByEmail(String email);
}
