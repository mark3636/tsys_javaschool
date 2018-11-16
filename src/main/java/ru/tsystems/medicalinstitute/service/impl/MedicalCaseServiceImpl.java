package ru.tsystems.medicalinstitute.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.medicalinstitute.bo.MedicalCase;
import ru.tsystems.medicalinstitute.dao.MedicalCaseDAO;
import ru.tsystems.medicalinstitute.mappers.MedicalCaseMapper;
import ru.tsystems.medicalinstitute.service.MedicalCaseService;

import java.util.List;

@Service
@Transactional
public class MedicalCaseServiceImpl implements MedicalCaseService {
    private final MedicalCaseDAO medicalCaseDAO;
    private MedicalCaseMapper mapper = Mappers.getMapper(MedicalCaseMapper.class);

    public MedicalCaseServiceImpl(final MedicalCaseDAO medicalCaseDAO) {
        this.medicalCaseDAO = medicalCaseDAO;
    }

    @Override
    public List<MedicalCase> listMedicalCases() {
        return mapper.toBos(medicalCaseDAO.listMedicalCases());
    }

    @Override
    public List<MedicalCase> getByPatientId(int patientId) {
        return mapper.toBos(medicalCaseDAO.getByPatientId(patientId));
    }

    @Override
    public void add(MedicalCase bo) {
        medicalCaseDAO.add(mapper.fromBo(bo));
    }

    @Override
    public void update(MedicalCase bo) {
        medicalCaseDAO.update(mapper.fromBo(bo));
    }

    @Override
    public MedicalCase getById(int id) {
        return mapper.toBo(medicalCaseDAO.getById(id));
    }

    @Override
    public void remove(int id) {
        medicalCaseDAO.remove(id);
    }
}
