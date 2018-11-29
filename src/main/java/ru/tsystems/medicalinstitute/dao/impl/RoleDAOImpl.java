package ru.tsystems.medicalinstitute.dao.impl;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.tsystems.medicalinstitute.dao.RoleDAO;
import ru.tsystems.medicalinstitute.model.RoleEntity;

import java.util.List;

@Repository
public class RoleDAOImpl extends AbstractDAOImpl<RoleEntity> implements RoleDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<RoleEntity> listRoles() {
        return getSession().createQuery("from RoleEntity").list();
    }

    @Override
    public RoleEntity getByName(String name) {
        Query query = getSession().createQuery("from RoleEntity where upper(name) = upper(:name)");
        query.setParameter("name", name);
        return (RoleEntity) query.getSingleResult();
    }
}
