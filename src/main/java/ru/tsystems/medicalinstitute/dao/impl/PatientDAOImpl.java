package ru.tsystems.medicalinstitute.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tsystems.medicalinstitute.dao.PatientDAO;
import ru.tsystems.medicalinstitute.model.PatientEntity;

import java.util.List;

@Repository
public class PatientDAOImpl extends AbstractDAOImpl<PatientEntity> implements PatientDAO {
    @SuppressWarnings("unchecked")
    @Override
    public List<PatientEntity> listPatients() {
        return getSession().createQuery("from PatientEntity").list();
    }
}
