package ru.tsystems.medicalinstitute.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.medicalinstitute.bo.Role;
import ru.tsystems.medicalinstitute.dao.RoleDAO;
import ru.tsystems.medicalinstitute.mappers.RoleMapper;
import ru.tsystems.medicalinstitute.service.RoleService;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleDAO roleDAO;
    private final RoleMapper mapper = Mappers.getMapper(RoleMapper.class);

    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> listRoles() {
        return mapper.toBos(roleDAO.listRoles());
    }

    @Override
    public Role getByName(String name) {
        return mapper.toBo(roleDAO.getByName(name));
    }

    @Override
    public void add(Role bo) {
        //
    }

    @Override
    public void update(Role bo) {
        //
    }

    @Override
    public Role getById(int id) {
        return mapper.toBo(roleDAO.getById(id));
    }

    @Override
    public void remove(int id) {
        //
    }
}
