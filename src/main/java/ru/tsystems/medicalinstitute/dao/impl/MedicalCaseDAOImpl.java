package ru.tsystems.medicalinstitute.dao.impl;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.tsystems.medicalinstitute.dao.MedicalCaseDAO;
import ru.tsystems.medicalinstitute.model.MedicalCaseEntity;

import java.util.List;

@Repository
public class MedicalCaseDAOImpl extends AbstractDAOImpl<MedicalCaseEntity> implements MedicalCaseDAO {
    @SuppressWarnings("unchecked")
    @Override
    public List<MedicalCaseEntity> listMedicalCases() {
        return getSession().createQuery("from MedicalCaseEntity").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MedicalCaseEntity> getByPatientId(int patientId) {
        Query query = getSession().createQuery("from MedicalCaseEntity where patient.id = :patientId");
        query.setParameter("patientId", patientId);
        return query.list();
    }
}
