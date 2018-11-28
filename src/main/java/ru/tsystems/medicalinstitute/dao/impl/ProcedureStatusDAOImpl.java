package ru.tsystems.medicalinstitute.dao.impl;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.tsystems.medicalinstitute.dao.ProcedureStatusDAO;
import ru.tsystems.medicalinstitute.model.ProcedureStatusEntity;

import java.util.List;

@Repository
public class ProcedureStatusDAOImpl extends AbstractDAOImpl<ProcedureStatusEntity> implements ProcedureStatusDAO {
    @SuppressWarnings("unchecked")
    @Override
    public List<ProcedureStatusEntity> listProcedureStatuses() {
        return getSession().createQuery("from ProcedureStatusEntity").list();
    }

    @Override
    public ProcedureStatusEntity getByName(String name) {
        Query query = getSession().createQuery("from ProcedureStatusEntity where upper(name) = upper(:name)");
        query.setParameter("name", name);
        return (ProcedureStatusEntity) query.getSingleResult();
    }
}