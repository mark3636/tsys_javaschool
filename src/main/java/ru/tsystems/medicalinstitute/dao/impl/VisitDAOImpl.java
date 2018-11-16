package ru.tsystems.medicalinstitute.dao.impl;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.tsystems.medicalinstitute.dao.VisitDAO;
import ru.tsystems.medicalinstitute.model.VisitEntity;

import java.util.Date;
import java.util.List;

@Repository
public class VisitDAOImpl extends AbstractDAOImpl<VisitEntity> implements VisitDAO {
    @SuppressWarnings("unchecked")
    @Override
    public List<VisitEntity> listVisits() {
        return getSession().createQuery("from VisitEntity ").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<VisitEntity> getByPatientId(int id) {
        Query query = getSession().createQuery("from VisitEntity where patient.id = :id");
        query.setParameter("id", id);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<VisitEntity> getByMedicalStaffAndVisitDate(int medicalStaffId, Date visitDate) {
        Query query = getSession().createQuery("from VisitEntity where medicalStaff.id = :medicalStaffId " +
                "and visitDate = :visitDate");
        query.setParameter("medicalStaffId", medicalStaffId);
        query.setParameter("visitDate", visitDate);
        return query.list();
    }
}
