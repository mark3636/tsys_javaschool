package ru.tsystems.medicalinstitute.mappers;

import org.mapstruct.Mapper;
import ru.tsystems.medicalinstitute.bo.ProcedureStatus;
import ru.tsystems.medicalinstitute.model.ProcedureStatusEntity;

import java.util.List;

@Mapper
public interface ProcedureStatusMapper {
    ProcedureStatus toBo(ProcedureStatusEntity procedureStatusEntity);
    ProcedureStatusEntity fromBo(ProcedureStatus procedureStatus);
    List<ProcedureStatus> toBos(List<ProcedureStatusEntity> procedureStatusEntities);
}
