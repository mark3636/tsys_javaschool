package ru.tsystems.medicalinstitute.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tsystems.medicalinstitute.dao.CaseStatusDAO;
import ru.tsystems.medicalinstitute.model.CaseStatusEntity;

import java.util.List;

@Repository
public class CaseStatusDAOImpl extends AbstractDAOImpl<CaseStatusEntity> implements CaseStatusDAO {
    @SuppressWarnings("unchecked")
    @Override
    public List<CaseStatusEntity> listCaseStatuses() {
        return getSession().createQuery("from CaseStatusEntity").list();
    }
}
