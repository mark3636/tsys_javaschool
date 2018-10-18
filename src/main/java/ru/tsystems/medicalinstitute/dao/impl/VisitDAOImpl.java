package ru.tsystems.medicalinstitute.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tsystems.medicalinstitute.dao.VisitDAO;
import ru.tsystems.medicalinstitute.model.VisitEntity;

import java.util.List;

@Repository
public class VisitDAOImpl extends AbstractDAOImpl<VisitEntity> implements VisitDAO {
    @SuppressWarnings("unchecked")
    @Override
    public List<VisitEntity> listVisits() {
        return getSession().createQuery("from VisitEntity ").list();
    }
}
