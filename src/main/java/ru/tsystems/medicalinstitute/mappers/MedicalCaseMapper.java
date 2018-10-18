package ru.tsystems.medicalinstitute.mappers;

import org.mapstruct.Mapper;
import ru.tsystems.medicalinstitute.bo.MedicalCase;
import ru.tsystems.medicalinstitute.model.MedicalCaseEntity;

import java.util.List;
import java.util.Set;

@Mapper(uses = {CaseStatusMapper.class, PatientMapper.class, MedicalStaffMapper.class, VisitMapper.class, DiagnosisMapper.class, PdfFileMapper.class})
public interface MedicalCaseMapper {
    MedicalCase toBo(MedicalCaseEntity medicalCaseEntity);
    MedicalCaseEntity fromBo(MedicalCase medicalCase);
    List<MedicalCase> toBos(List<MedicalCaseEntity> medicalCaseEntities);
}
