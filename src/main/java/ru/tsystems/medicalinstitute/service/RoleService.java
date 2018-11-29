package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.Role;

import java.util.List;

public interface RoleService extends AbstractService<Role> {
    List<Role> listRoles();
    Role getByName(String name);
}
