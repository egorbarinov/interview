package com.egorbarinov.demorepository.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;

public class RepositoryImpl<T,ID extends Serializable> implements Repository<T, ID> {

    private SessionFactory factory = null;

    private Class<T> typeClass = null;

    public RepositoryImpl(Class<T> typeClass) {
        this.typeClass = typeClass;
        this.factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    @Override
    public T findById(Class<T> typeClass, ID id) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            final T object = session.get(typeClass, id);
            session.getTransaction().commit();
            return object;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // метод не отрабатывает. выдает беcконечный java.lang.StackOverflowError: null. не могу понять, почему??
    @Override
    public void save(T entity) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T entity) {

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<T> findAll() {
        List<T> entities;
        try (Session session = factory.getCurrentSession()) {
            session.getTransaction().begin();
            entities = session.createQuery("from " + typeClass.getSimpleName(), typeClass).getResultList();
            session.getTransaction().commit();
        }
        return entities;
    }

}
