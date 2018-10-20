package ru.tsystems.medicalinstitute.mapper;

import ru.tsystems.medicalinstitute.bo.MedicalCase;
import ru.tsystems.medicalinstitute.bo.Patient;
import ru.tsystems.medicalinstitute.model.MedicalCaseEntity;
import ru.tsystems.medicalinstitute.model.PatientEntity;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PatientMapper {
    public static Patient toBo(PatientEntity patientEntity) {
        return new Patient(patientEntity.getId(), patientEntity.getName(), patientEntity.getSurname(), patientEntity.getBirthday(), patientEntity.getPassportDetails(), patientEntity.getAddress(), patientEntity.getEmail(), patientEntity.getPhoneNumber(), patientEntity.getComment(), patientEntity.getSocialSecurityNumber()/*, MedicalCaseMapper.toBo(patientEntity.getMedicalCases()), VisitMapper.toBo(patientEntity.getVisits())*/);
    }

    public static Set<Patient> toBo(Set<PatientEntity> medicalCaseEntitySet) {
        Set<Patient> set = new HashSet<>();
        for(PatientEntity mce : medicalCaseEntitySet) {
            set.add(toBo(mce));
        }
        return set;
    }

    public static List<Patient> toBo(List<PatientEntity> medicalCaseEntitySet) {
        List<Patient> set = new LinkedList<>();
        for(PatientEntity mce : medicalCaseEntitySet) {
            set.add(toBo(mce));
        }
        return set;
    }
}
