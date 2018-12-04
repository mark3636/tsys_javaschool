package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.Role;

import java.util.List;

public interface RoleService extends AbstractService<Role> {
    /**
     * Lists all roles
     * @return List of roles
     */
    List<Role> listRoles();

    /**
     * Returns role by its name
     * @param name role name
     * @return Role with particular name
     */
    Role getByName(String name);
}
