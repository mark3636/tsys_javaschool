package ru.tsystems.medicalinstitute.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.medicalinstitute.bo.MedicalCase;
import ru.tsystems.medicalinstitute.bo.Patient;
import ru.tsystems.medicalinstitute.dao.PatientDAO;
import ru.tsystems.medicalinstitute.mappers.PatientMapper;
import ru.tsystems.medicalinstitute.service.CaseStatusService;
import ru.tsystems.medicalinstitute.service.MedicalCaseService;
import ru.tsystems.medicalinstitute.service.MedicalStaffService;
import ru.tsystems.medicalinstitute.service.PatientService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    private final static String OPENED = "OPENED";
    private final static String CLOSED = "CLOSED";
    private final static String COMPLETED = "COMPLETED";

    private final PatientDAO patientDAO;
    private final MedicalCaseService medicalCaseService;
    private final CaseStatusService caseStatusService;
    private final MedicalStaffService medicalStaffService;

    private PatientMapper mapper = Mappers.getMapper(PatientMapper.class);

    public PatientServiceImpl(final PatientDAO patientDAO, final MedicalCaseService medicalCaseService, final CaseStatusService caseStatusService, final MedicalStaffService medicalStaffService) {
        this.patientDAO = patientDAO;
        this.medicalCaseService = medicalCaseService;
        this.caseStatusService = caseStatusService;
        this.medicalStaffService = medicalStaffService;
    }

    @Override
    @Transactional
    public void add(Patient patient) {

        patientDAO.add(mapper.fromBo(patient));
    }

    @Override
    public void update(Patient patient) {
        patientDAO.update(mapper.fromBo(patient));
    }

    @Override
    public List<Patient> listPatients() {
        return mapper.toBos(patientDAO.listPatients());
    }

    @Override
    public List<Patient> filterPatients(String surname, String birthday, String medicalCaseNumber) throws ParseException {
        List<Patient> patients = listPatients();
        if (surname != null && !surname.isEmpty()) {
            patients = patients.stream()
                    .filter(patient -> patient.getSurname().toLowerCase().contains(surname)).collect(Collectors.toList());
        }

        if (birthday != null && !birthday.isEmpty()) {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            patients = patients.stream()
                    .filter(patient -> patient.getBirthday().equals(date)).collect(Collectors.toList());
        }

        List<MedicalCase> medicalCases = medicalCaseService.listMedicalCases();

        if (medicalCaseNumber != null && !medicalCaseNumber.isEmpty()) {
            medicalCases = medicalCases.stream()
                    .filter(medicalCase -> medicalCase.getNumber().toLowerCase().contains(medicalCaseNumber)).collect(Collectors.toList());

            if (medicalCases.isEmpty()) {
                patients = new ArrayList<>();
            }

            for (MedicalCase medicalCase : medicalCases) {
                patients = patients.stream()
                        .filter(patient -> patient.getId() == medicalCase.getPatient().getId()).collect(Collectors.toList());
            }
        }

        return patients;
    }

    @Override
    public Patient getBySocialSecurityNumber(int socialSecurityNumber) {
        return mapper.toBo(patientDAO.getBySocialSecurityNumber(socialSecurityNumber));
    }

    @Override
    public String getPatientStatus(int id) {
        List<MedicalCase> medicalCases = medicalCaseService.getByPatientId(id);
        String patientStatus = "Undefined";

        if (!medicalCases.isEmpty()) {
            patientStatus = "Discharged";

            for (MedicalCase medicalCase : medicalCases) {
                if (medicalCase.getCaseStatus().getName().equals(OPENED)) {
                    patientStatus = "On treatment";
                    break;
                }
            }
        }

        return patientStatus;
    }

    @Override
    public void addWithInitialMedicalCase(Patient patient, String medicalStaffEmail) {
        add(patient);

        MedicalCase medicalCase = new MedicalCase();
        medicalCase.setMedicalStaff(medicalStaffService.findByEmail(medicalStaffEmail));
        medicalCase.setBeginningDate(new Date());
        medicalCase.setPatient(getBySocialSecurityNumber(patient.getSocialSecurityNumber()));
        medicalCase.setCaseStatus(caseStatusService.getByName(OPENED));
        medicalCase.setNumber("_" + patient.getSocialSecurityNumber());

        medicalCaseService.add(medicalCase);
    }

    @Override
    public Patient getById(int id) {
        return mapper.toBo(patientDAO.getById(id));
    }

    @Override
    public void remove(int id) {
        patientDAO.remove(id);
    }
}
