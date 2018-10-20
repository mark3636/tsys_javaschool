package ru.tsystems.medicalinstitute.mappers;

import org.mapstruct.Mapper;
import ru.tsystems.medicalinstitute.bo.MedicalStaff;
import ru.tsystems.medicalinstitute.model.MedicalStaffEntity;

import java.util.List;

@Mapper(uses = {DiagnosisMapper.class/*, VisitMapper.class*//*, MedicalCaseMapper.class*/})
public interface MedicalStaffMapper {
    MedicalStaff toBo(MedicalStaffEntity medicalStaffEntity);
    MedicalStaffEntity fromBo(MedicalStaff medicalStaff);
    List<MedicalStaff> toBos(List<MedicalStaffEntity> visitEntityList);
}
