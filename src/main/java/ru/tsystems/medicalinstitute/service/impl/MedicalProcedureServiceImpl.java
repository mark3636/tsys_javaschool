package ru.tsystems.medicalinstitute.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.medicalinstitute.bo.MedicalProcedure;
import ru.tsystems.medicalinstitute.dao.MedicalProcedureDAO;
import ru.tsystems.medicalinstitute.mappers.MedicalProcedureMapper;
import ru.tsystems.medicalinstitute.service.MedicalProcedureService;

import java.util.List;

@Service
@Transactional
public class MedicalProcedureServiceImpl implements MedicalProcedureService {
    private final MedicalProcedureDAO medicalProcedureDAO;
    private MedicalProcedureMapper mapper = Mappers.getMapper(MedicalProcedureMapper.class);

    public MedicalProcedureServiceImpl(final MedicalProcedureDAO medicalProcedureDAO) {
        this.medicalProcedureDAO = medicalProcedureDAO;
    }

    @Override
    public List<MedicalProcedure> listMedicalProcedures() {
        return mapper.toBos(medicalProcedureDAO.listMedicalProcedures());
    }

    @Override
    public List<MedicalProcedure> getByMedicalCase(int caseId) {
        return mapper.toBos(medicalProcedureDAO.getByMedicalCase(caseId));
    }

    @Override
    public List<MedicalProcedure> filter(String patientName, Integer socialSecurityNumber, String caseNumber) {
        return mapper.toBos(medicalProcedureDAO.filter(patientName, socialSecurityNumber, caseNumber));
    }

    @Override
    public void add(MedicalProcedure bo) {
        medicalProcedureDAO.add(mapper.fromBo(bo));
    }

    @Override
    public void update(MedicalProcedure bo) {
        medicalProcedureDAO.update(mapper.fromBo(bo));
    }

    @Override
    public MedicalProcedure getById(int id) {
        return mapper.toBo(medicalProcedureDAO.getById(id));
    }

    @Override
    public void remove(int id) {
        medicalProcedureDAO.remove(id);
    }
}
