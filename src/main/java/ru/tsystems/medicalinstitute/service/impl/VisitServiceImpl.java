package ru.tsystems.medicalinstitute.service.impl;

import org.apache.commons.lang3.time.DateUtils;
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
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class VisitServiceImpl implements VisitService {
    private final VisitDAO visitDAO;

    private VisitMapper mapper = Mappers.getMapper(VisitMapper.class);
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static final String MAX_TIME = "16:00";

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
        Date date = dateFormat.parse(visitDate);
        return mapper.toBos(visitDAO.getByMedicalStaffAndVisitDate(medicalStaffId, date));
    }

    @Override
    public List<String> getExistedTime(int medicalStaffId, String visitDate) throws ParseException {
        List<Visit> existedVisits;
        List<String> existedTime = null;

        if (visitDate != null) {
            existedVisits = getByMedicalStaffAndVisitDate(medicalStaffId, visitDate);
            if (!existedVisits.isEmpty()) {
                existedTime = new LinkedList<>();
                for (Visit visit : existedVisits) {
                    existedTime.add(timeFormat.format(visit.getBeginningTime()));
                    existedTime.add(timeFormat.format(visit.getEndingTime()));
                }
            }
        }

        return existedTime;
    }

    @Override
    public List<String> getEndingTime(int medicalStaffId, String visitDate, String beginningTime) throws ParseException {
        List<Visit> existedVisits;
        List<String> timeBorder = new LinkedList<>();

        Date minTime = DateUtils.addMinutes(timeFormat.parse(beginningTime), 15);
        Date maxTime = DateUtils.addMinutes(timeFormat.parse(beginningTime), 60);

        if (visitDate != null) {
            existedVisits = getByMedicalStaffAndVisitDate(medicalStaffId, visitDate);
            if (!existedVisits.isEmpty()) {
                for (Visit visit : existedVisits) {
                    if((visit.getBeginningTime().after(minTime) || visit.getBeginningTime().equals(minTime))
                            && (visit.getBeginningTime().before(maxTime) || visit.getBeginningTime().equals(maxTime))) {
                        maxTime = visit.getBeginningTime();
                    }
                }
            }
        }

        if (maxTime.after(timeFormat.parse(MAX_TIME))) {
            maxTime = timeFormat.parse(MAX_TIME);
        }

        timeBorder.add(timeFormat.format(minTime));
        timeBorder.add(timeFormat.format(maxTime));

        return timeBorder;
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
