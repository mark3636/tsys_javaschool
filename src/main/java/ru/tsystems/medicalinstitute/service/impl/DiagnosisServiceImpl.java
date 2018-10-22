package ru.tsystems.medicalinstitute.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.medicalinstitute.bo.Diagnosis;
import ru.tsystems.medicalinstitute.dao.DiagnosisDAO;
import ru.tsystems.medicalinstitute.mappers.DiagnosisMapper;
import ru.tsystems.medicalinstitute.service.DiagnosisService;

import java.util.List;

@Service
@Transactional
public class DiagnosisServiceImpl implements DiagnosisService {
    @Autowired
    private DiagnosisDAO diagnosisDAO;
    private DiagnosisMapper mapper = Mappers.getMapper(DiagnosisMapper.class);

    @Override
    public List<Diagnosis> listDiagnosis() {
        return mapper.toBos(diagnosisDAO.listDiagnoses());
    }

    @Override
    public List<Diagnosis> getByMedicalCaseId(int id) {
        return mapper.toBos(diagnosisDAO.getByMedicalCaseId(id));
    }

    @Override
    public void add(Diagnosis bo) {
        diagnosisDAO.add(mapper.fromBo(bo));
    }

    @Override
    public void update(Diagnosis bo) {
        diagnosisDAO.update(mapper.fromBo(bo));
    }

    @Override
    public Diagnosis getById(int id) {
        return mapper.toBo(diagnosisDAO.getById(id));
    }

    @Override
    public void remove(int id) {
        diagnosisDAO.remove(id);
    }
}
