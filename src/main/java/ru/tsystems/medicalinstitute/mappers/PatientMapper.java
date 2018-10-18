package ru.tsystems.medicalinstitute.mappers;

import org.mapstruct.Mapper;
import ru.tsystems.medicalinstitute.bo.Patient;
import ru.tsystems.medicalinstitute.model.PatientEntity;

import java.util.List;

@Mapper(uses = {VisitMapper.class, MedicalCaseMapper.class})
public interface PatientMapper {
    Patient toBo(PatientEntity patientEntity);
    PatientEntity fromBo(Patient patient);
    List<Patient> toBos(List<PatientEntity> patientEntities);
}
