package ru.tsystems.medicalinstitute.mappers;

import org.mapstruct.Mapper;
import ru.tsystems.medicalinstitute.bo.MedicalProcedure;
import ru.tsystems.medicalinstitute.model.MedicalProcedureEntity;

import java.util.List;

@Mapper(uses = {MedicalCaseMapper.class, ProcedureStatusMapper.class, MedicalStaffMapper.class})
public interface MedicalProcedureMapper {
    MedicalProcedure toBo(MedicalProcedureEntity medicalProcedureEntity);
    MedicalProcedureEntity fromBo(MedicalProcedure medicalProcedure);
    List<MedicalProcedure> toBos(List<MedicalProcedureEntity> medicalProcedureEntities);
}
