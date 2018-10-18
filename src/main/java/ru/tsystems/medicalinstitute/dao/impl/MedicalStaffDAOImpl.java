package ru.tsystems.medicalinstitute.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tsystems.medicalinstitute.dao.MedicalStaffDAO;
import ru.tsystems.medicalinstitute.model.MedicalStaffEntity;

import java.util.List;

@Repository
public class MedicalStaffDAOImpl extends AbstractDAOImpl<MedicalStaffEntity> implements MedicalStaffDAO {
    @SuppressWarnings("unchecked")
    @Override
    public List<MedicalStaffEntity> listMedicalStaff() {
        return getSession().createQuery("from MedicalStaffEntity").list();
    }
}
