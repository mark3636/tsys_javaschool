package ru.tsystems.medicalinstitute.mappers;

import org.mapstruct.Mapper;
import ru.tsystems.medicalinstitute.bo.MedicalCase;
import ru.tsystems.medicalinstitute.model.MedicalCaseEntity;

import java.util.List;

@Mapper(uses = {CaseStatusMapper.class, MedicalStaffMapper.class, PatientMapper.class})
public interface MedicalCaseMapper {
    MedicalCase toBo(MedicalCaseEntity medicalCaseEntity);
    MedicalCaseEntity fromBo(MedicalCase medicalCase);
    List<MedicalCase> toBos(List<MedicalCaseEntity> medicalCaseEntities);
}
