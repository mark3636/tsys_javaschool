package ru.tsystems.medicalinstitute.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.medicalinstitute.bo.ProcedureStatus;
import ru.tsystems.medicalinstitute.dao.ProcedureStatusDAO;
import ru.tsystems.medicalinstitute.mappers.ProcedureStatusMapper;
import ru.tsystems.medicalinstitute.service.ProcedureStatusService;

@Service
@Transactional
public class ProcedureStatusServiceImpl implements ProcedureStatusService {
    private final ProcedureStatusDAO procedureStatusDAO;
    private ProcedureStatusMapper mapper = Mappers.getMapper(ProcedureStatusMapper.class);

    public ProcedureStatusServiceImpl(final ProcedureStatusDAO procedureStatusDAO) {
        this.procedureStatusDAO = procedureStatusDAO;
    }

    @Override
    public ProcedureStatus getByName(String name) {
        return mapper.toBo(procedureStatusDAO.getByName(name));
    }

    @Override
    public void add(ProcedureStatus bo) {
        //
    }

    @Override
    public void update(ProcedureStatus bo) {
        //
    }

    @Override
    public ProcedureStatus getById(int id) {
        return mapper.toBo(procedureStatusDAO.getById(id));
    }

    @Override
    public void remove(int id) {
        //
    }
}
