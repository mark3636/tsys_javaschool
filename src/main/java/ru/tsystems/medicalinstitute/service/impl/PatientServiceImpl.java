package ru.tsystems.medicalinstitute.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.medicalinstitute.bo.Patient;
import ru.tsystems.medicalinstitute.dao.PatientDAO;
import ru.tsystems.medicalinstitute.mappers.PatientMapper;
import ru.tsystems.medicalinstitute.service.PatientService;

import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientDAO patientDAO;

    private PatientMapper patientMapper = Mappers.getMapper(PatientMapper.class);

    @Override
    @Transactional
    public void addPatient(Patient patient) {
        patientDAO.add(patientMapper.fromBo(patient));
    }

    @Override
    public void updatePatient(Patient patient) {
        patientDAO.update(patientMapper.fromBo(patient));
    }

    @Override
    public List<Patient> listPatients() {
        return patientMapper.toBos(patientDAO.listPatients());
    }

    @Override
    public Patient getPatientById(int id) {
        return patientMapper.toBo(patientDAO.getById(id));
    }

    @Override
    public void removePatient(int id) {
        patientDAO.remove(id);
    }
}
