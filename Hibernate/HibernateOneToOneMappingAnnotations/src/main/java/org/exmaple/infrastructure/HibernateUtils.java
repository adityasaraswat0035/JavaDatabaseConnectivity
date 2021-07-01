package org.exmaple.infrastructure;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        try {
            if (sessionFactory == null) {
                Configuration configuration = new Configuration();
                configuration.configure("hibenate.cfg.xml");
                sessionFactory = configuration.buildSessionFactory();
            }
            return sessionFactory;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
