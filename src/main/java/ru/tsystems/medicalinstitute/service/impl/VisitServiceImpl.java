package ru.tsystems.medicalinstitute.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.medicalinstitute.bo.Visit;
import ru.tsystems.medicalinstitute.dao.VisitDAO;
import ru.tsystems.medicalinstitute.mappers.VisitMapper;
import ru.tsystems.medicalinstitute.service.VisitService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class VisitServiceImpl implements VisitService {
    private final VisitDAO visitDAO;

    private VisitMapper mapper = Mappers.getMapper(VisitMapper.class);

    public VisitServiceImpl(final VisitDAO visitDAO) {
        this.visitDAO = visitDAO;
    }

    @Override
    public List<Visit> listVisits() {
        return mapper.toBos(visitDAO.listVisits());
    }

    @Override
    public List<Visit> getByPatientId(int id) {
        return mapper.toBos(visitDAO.getByPatientId(id));
    }

    @Override
    public List<Visit> getByMedicalStaffAndVisitDate(int medicalStaffId, String visitDate) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(visitDate);
        return mapper.toBos(visitDAO.getByMedicalStaffAndVisitDate(medicalStaffId, date));
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
