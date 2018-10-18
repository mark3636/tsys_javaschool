package ru.tsystems.medicalinstitute.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tsystems.medicalinstitute.dao.AbstractDAO;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractDAOImpl<T> implements AbstractDAO<T> {
    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDAOImpl()
    {
        this.persistentClass = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(T entity) {
        getSession().persist(entity);
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public T getById(int id) {
        return getSession().load(persistentClass, id);
    }

    @Override
    public void remove(int id) {
        T entity = (T) getSession().load(persistentClass, id);
        if(entity != null) {
            getSession().remove(entity);
        }
    }
}
