package ru.tsystems.medicalinstitute.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tsystems.medicalinstitute.dao.DiagnosisDAO;
import ru.tsystems.medicalinstitute.model.DiagnosisEntity;

import java.util.List;

@Repository
public class DiagnosisDAOImpl extends AbstractDAOImpl<DiagnosisEntity> implements DiagnosisDAO {
    @SuppressWarnings("unchecked")
    @Override
    public List<DiagnosisEntity> listDiagnoses() {
        return getSession().createQuery("from DiagnosisEntity").list();
    }
}
