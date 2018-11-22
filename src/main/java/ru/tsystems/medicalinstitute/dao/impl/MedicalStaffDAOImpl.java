package ru.tsystems.medicalinstitute.dao.impl;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.tsystems.medicalinstitute.dao.MedicalStaffDAO;
import ru.tsystems.medicalinstitute.model.MedicalStaffEntity;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class MedicalStaffDAOImpl extends AbstractDAOImpl<MedicalStaffEntity> implements MedicalStaffDAO {
    @SuppressWarnings("unchecked")
    @Override
    public List<MedicalStaffEntity> listMedicalStaff() {
        return getSession().createQuery("from MedicalStaffEntity").list();
    }

    @Override
    public MedicalStaffEntity findByEmail(String email) {
        Query query = getSession().createQuery("from MedicalStaffEntity where email = :email");
        query.setParameter("email", email);
        try {
            return (MedicalStaffEntity) query.getSingleResult();
        }
        catch (NoResultException ex) {
            return null;
        }
    }
}
