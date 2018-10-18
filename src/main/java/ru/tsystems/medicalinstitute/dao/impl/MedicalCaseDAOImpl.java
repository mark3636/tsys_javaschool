package ru.tsystems.medicalinstitute.dao.impl;

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
}
