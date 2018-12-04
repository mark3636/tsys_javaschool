package ru.tsystems.medicalinstitute.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.tsystems.medicalinstitute.bo.MedicalStaff;

import java.util.List;

public interface MedicalStaffService extends AbstractService<MedicalStaff>, UserDetailsService {
    /**
     * Lists all medical staff
     * @return List of medical staff
     */
    List<MedicalStaff> listMedicalStaff();

    /**
     * Returns medical staff by his email
     * @param email medical staff email
     * @return Medical staff
     */
    MedicalStaff findByEmail(String email);

    /**
     * Returns medical staff by their position
     * @param position position
     * @return List of medical staff
     */
    List<MedicalStaff> getByPosition(String position);
}
