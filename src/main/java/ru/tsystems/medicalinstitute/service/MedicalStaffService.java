package ru.tsystems.medicalinstitute.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.tsystems.medicalinstitute.bo.MedicalStaff;

import java.util.List;

public interface MedicalStaffService extends AbstractService<MedicalStaff>, UserDetailsService {
    List<MedicalStaff> listMedicalStaff();
    MedicalStaff findByEmail(String email);
}
