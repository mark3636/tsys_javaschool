package ru.tsystems.medicalinstitute.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.medicalinstitute.bo.MedicalStaff;
import ru.tsystems.medicalinstitute.dao.MedicalStaffDAO;
import ru.tsystems.medicalinstitute.mappers.MedicalStaffMapper;
import ru.tsystems.medicalinstitute.service.MedicalStaffService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MedicalStaffServiceImpl implements MedicalStaffService {
    private final MedicalStaffDAO medicalStaffDAO;
    private final PasswordEncoder passwordEncoder;
    private MedicalStaffMapper mapper = Mappers.getMapper(MedicalStaffMapper.class);

    public MedicalStaffServiceImpl(final MedicalStaffDAO medicalStaffDAO, final PasswordEncoder passwordEncoder) {
        this.medicalStaffDAO = medicalStaffDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<MedicalStaff> listMedicalStaff() {
        return mapper.toBos(medicalStaffDAO.listMedicalStaff());
    }

    @Override
    public MedicalStaff findByEmail(String email) {
        return mapper.toBo(medicalStaffDAO.findByEmail(email));
    }

    @Override
    public List<MedicalStaff> getByPosition(String position) {
        return mapper.toBos(medicalStaffDAO.getByPosition(position));
    }

    @Override
    public void add(MedicalStaff bo)
    {
        bo.setPassword(passwordEncoder.encode(bo.getPassword()));
        medicalStaffDAO.add(mapper.fromBo(bo));
    }

    @Override
    public void update(MedicalStaff bo) {
        medicalStaffDAO.update(mapper.fromBo(bo));
    }

    @Override
    public MedicalStaff getById(int id) {
        return mapper.toBo(medicalStaffDAO.getById(id));
    }

    @Override
    public void remove(int id) {
        medicalStaffDAO.remove(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        MedicalStaff medicalStaff = findByEmail(s);
        if (medicalStaff == null) {
            throw new UsernameNotFoundException("User was not found");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + medicalStaff.getRole().getName().toUpperCase()));

        return new User(medicalStaff.getEmail(), medicalStaff.getPassword(), true, true, true, true, grantedAuthorities);
    }
}
