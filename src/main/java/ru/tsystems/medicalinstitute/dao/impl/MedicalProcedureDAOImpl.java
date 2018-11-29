package ru.tsystems.medicalinstitute.dao.impl;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.tsystems.medicalinstitute.dao.MedicalProcedureDAO;
import ru.tsystems.medicalinstitute.model.MedicalProcedureEntity;

import java.util.List;

@Repository
public class MedicalProcedureDAOImpl extends AbstractDAOImpl<MedicalProcedureEntity> implements MedicalProcedureDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<MedicalProcedureEntity> listMedicalProcedures() {
        return getSession().createQuery("from MedicalProcedureEntity").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MedicalProcedureEntity> getByMedicalCase(int caseId) {
        Query query = getSession().createQuery("from MedicalProcedureEntity where medicalCase.id = :caseId");
        query.setParameter("caseId", caseId);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MedicalProcedureEntity> filter(String patientName, Integer socialSecurityNumber, String caseNumber) {
        Query query = getSession().createQuery("from MedicalProcedureEntity" +
                " where upper(concat(medicalCase.patient.name, medicalCase.patient.surname)) like upper(concat('%', :patientName, '%'))" +
                " and (:socialSecurityNumber is null" +
                " or concat('', medicalCase.patient.socialSecurityNumber) like concat('%', :socialSecurityNumber, '%'))" +
                " and upper(medicalCase.number) like upper(concat('%', :caseNumber, '%'))");
        query.setParameter("patientName", patientName);
        query.setParameter("socialSecurityNumber", socialSecurityNumber);
        query.setParameter("caseNumber", caseNumber);
        return query.list();
    }
}