package ru.tsystems.medicalinstitute.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.medicalinstitute.bo.Visit;
import ru.tsystems.medicalinstitute.dao.VisitDAO;
import ru.tsystems.medicalinstitute.mappers.VisitMapper;
import ru.tsystems.medicalinstitute.service.VisitService;

import java.util.List;

@Service
@Transactional
public class VisitServiceImpl implements VisitService {
    @Autowired
    private VisitDAO visitDAO;

    private VisitMapper mapper = Mappers.getMapper(VisitMapper.class);

    @Override
    public List<Visit> listVisits() {
        return mapper.toBos(visitDAO.listVisits());
    }

    @Override
    public List<Visit> getByPatientId(int id) {
        return mapper.toBos(visitDAO.getByPatientId(id));
    }

    @Override
    public void add(Visit bo) {
        visitDAO.add(mapper.fromBo(bo));
    }

    @Override
    public void update(Visit bo) {
        visitDAO.update(mapper.fromBo(bo));
    }

    @Override
    public Visit getById(int id) {
        return mapper.toBo(visitDAO.getById(id));
    }

    @Override
    public void remove(int id) {
        visitDAO.remove(id);
    }
}
