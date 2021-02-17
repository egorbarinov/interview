package com.egorbarinov.demorepository.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {
    private SessionFactory factory;

    public MySessionFactory() {
        this.factory = new Configuration()
            .configure("configs/hibernate.cfg.xml")
            .buildSessionFactory();;
    }

    public Session getSession() {
        return factory.getCurrentSession();
    }

    public Transaction begin() {
        return getSession().beginTransaction();
    }

    public void commit() {
        getSession().getTransaction().commit();
        getSession().close();
    }

    public void closeSessionFactory() {
        factory.close();
    }
}
