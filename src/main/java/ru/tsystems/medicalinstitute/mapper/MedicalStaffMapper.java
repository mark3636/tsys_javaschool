package ru.tsystems.medicalinstitute.mapper;

import ru.tsystems.medicalinstitute.bo.Diagnosis;
import ru.tsystems.medicalinstitute.bo.MedicalStaff;
import ru.tsystems.medicalinstitute.model.MedicalStaffEntity;

import java.util.HashSet;
import java.util.Set;

public class MedicalStaffMapper {
    public static MedicalStaff toBo(MedicalStaffEntity medicalStaffEntity) {
        return new MedicalStaff(medicalStaffEntity.getId(), medicalStaffEntity.getName(), medicalStaffEntity.getSurname(), medicalStaffEntity.getBirthday(), medicalStaffEntity.getPassword(), medicalStaffEntity.getEmail() /*, DiagnosisMapper.toBo(medicalStaffEntity.getDiagnoses()), MedicalCaseMapper.toBo(medicalStaffEntity.getMedicalCases()), VisitMapper.toBo(medicalStaffEntity.getVisits())*/);
    }

    public static Set<MedicalStaff> toBo(Set<MedicalStaffEntity> medicalCaseEntitySet) {
        Set<MedicalStaff> set = new HashSet<>();
        for(MedicalStaffEntity mce : medicalCaseEntitySet) {
            set.add(toBo(mce));
        }
        return set;
    }
}
