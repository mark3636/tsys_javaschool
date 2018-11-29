package ru.tsystems.medicalinstitute.mappers;

import org.mapstruct.Mapper;
import ru.tsystems.medicalinstitute.bo.Role;
import ru.tsystems.medicalinstitute.model.RoleEntity;

import java.util.List;

@Mapper
public interface RoleMapper {
    Role toBo(RoleEntity roleEntity);
    RoleEntity fromBo(Role role);
    List<Role> toBos(List<RoleEntity> roleEntities);
}
