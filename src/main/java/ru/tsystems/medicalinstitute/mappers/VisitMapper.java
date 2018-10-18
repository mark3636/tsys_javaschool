package ru.tsystems.medicalinstitute.mappers;

import org.mapstruct.Mapper;
import ru.tsystems.medicalinstitute.bo.Visit;
import ru.tsystems.medicalinstitute.model.VisitEntity;

import java.util.List;

@Mapper(uses = {MedicalCaseMapper.class, MedicalStaffMapper.class, PatientMapper.class})
public interface VisitMapper {
    Visit toBo(VisitEntity visitEntity);
    VisitEntity fromBo(Visit visit);
    List<Visit> toBos(List<VisitEntity> visitEntities);
}
