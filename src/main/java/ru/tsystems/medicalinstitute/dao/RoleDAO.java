package ru.tsystems.medicalinstitute.dao;

import ru.tsystems.medicalinstitute.model.RoleEntity;

import java.util.List;

public interface RoleDAO extends AbstractDAO<RoleEntity> {
    List<RoleEntity> listRoles();
    RoleEntity getByName(String name);
}
