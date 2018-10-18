package ru.tsystems.medicalinstitute.mappers;

import org.mapstruct.Mapper;
import ru.tsystems.medicalinstitute.bo.Diagnosis;
import ru.tsystems.medicalinstitute.model.DiagnosisEntity;

import java.util.List;

@Mapper(uses = {MedicalStaffMapper.class, MedicalCaseMapper.class})
public interface DiagnosisMapper {
    Diagnosis toBo(DiagnosisEntity diagnosisEntity);
    DiagnosisEntity fromBo(Diagnosis diagnosis);
    List<Diagnosis> toBos(List<DiagnosisEntity> diagnosisEntities);
}
