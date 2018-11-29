package ru.tsystems.medicalinstitute.dao.impl;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.tsystems.medicalinstitute.dao.PatientDAO;
import ru.tsystems.medicalinstitute.model.PatientEntity;

import java.util.Date;
import java.util.List;

@Repository
public class PatientDAOImpl extends AbstractDAOImpl<PatientEntity> implements PatientDAO {
    @SuppressWarnings("unchecked")
    @Override
    public List<PatientEntity> listPatients() {
        return getSession().createQuery("from PatientEntity").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PatientEntity> filterPatients(String surname, Date birthday, String medicalCaseNumber) {
        Query query = getSession().createQuery(
                "select distinct pe" +
                        " from PatientEntity as pe inner join MedicalCaseEntity as mce" +
                        " on pe.id = mce.patient.id" +
                        " where upper(concat(pe.name, pe.surname)) like upper(concat('%', :surname, '%'))" +
                        " and upper(mce.number) like upper(concat('%', :medicalCaseNumber, '%'))" +
                        " and (:birthday is null or :birthday = pe.birthday)");
        query.setParameter("surname", surname);
        query.setParameter("medicalCaseNumber", medicalCaseNumber);
        query.setParameter("birthday", birthday);
        return query.list();
    }

    @Override
    public PatientEntity getBySocialSecurityNumber(int socialSecurityNumber) {
        Query query = getSession().createQuery("from PatientEntity where socialSecurityNumber = :ssn");
        query.setParameter("ssn", socialSecurityNumber);
        return (PatientEntity) query.getSingleResult();
    }
}
