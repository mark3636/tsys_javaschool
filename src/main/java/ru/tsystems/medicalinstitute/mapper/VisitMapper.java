package ru.tsystems.medicalinstitute.mapper;

import ru.tsystems.medicalinstitute.bo.MedicalCase;
import ru.tsystems.medicalinstitute.bo.Visit;
import ru.tsystems.medicalinstitute.model.VisitEntity;

import java.util.HashSet;
import java.util.Set;

public class VisitMapper {
    public static Visit toBo(VisitEntity visitEntity) {
        return new Visit(visitEntity.getId(), visitEntity.getBeginningDate(), visitEntity.getEndingDate(), MedicalCaseMapper.toBo(visitEntity.getMedicalCase()), MedicalStaffMapper.toBo(visitEntity.getMedicalStaff()), PatientMapper.toBo(visitEntity.getPatient()));
    }

    public static Set<Visit> toBo(Set<VisitEntity> entities) {
        Set<Visit> set = new HashSet<>();
        for(VisitEntity entity : entities) {
            set.add(toBo(entity));
        }
        return set;
    }
}
