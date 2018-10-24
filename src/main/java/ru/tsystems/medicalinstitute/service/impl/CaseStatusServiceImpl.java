package ru.tsystems.medicalinstitute.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.medicalinstitute.bo.CaseStatus;
import ru.tsystems.medicalinstitute.dao.CaseStatusDAO;
import ru.tsystems.medicalinstitute.mappers.CaseStatusMapper;
import ru.tsystems.medicalinstitute.service.CaseStatusService;

@Service
@Transactional
public class CaseStatusServiceImpl implements CaseStatusService {
    @Autowired
    private CaseStatusDAO caseStatusDAO;
    CaseStatusMapper mapper = Mappers.getMapper(CaseStatusMapper.class);


    @Override
    public CaseStatus getByName(String name) {
        return mapper.toBo(caseStatusDAO.getByName(name));
    }

    @Override
    public void add(CaseStatus bo) {
        //
    }

    @Override
    public void update(CaseStatus bo) {
        //
    }

    @Override
    public CaseStatus getById(int id) {
        return mapper.toBo(caseStatusDAO.getById(id));
    }

    @Override
    public void remove(int id) {
        //
    }
}
