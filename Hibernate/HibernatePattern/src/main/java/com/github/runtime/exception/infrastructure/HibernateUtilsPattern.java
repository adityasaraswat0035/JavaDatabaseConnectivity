package com.github.runtime.exception.infrastructure;

import com.github.runtime.exception.entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.imageio.spi.ServiceRegistry;
import java.util.Properties;

public class HibernateUtilsPattern {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        try {
            if (sessionFactory == null) {
                Configuration configuration = new Configuration();
                Properties properties = new Properties();
                ClassLoader loader = Thread.currentThread().getContextClassLoader();
                properties.load(loader.getResourceAsStream("hibernate.cfg.properties"));
                configuration.addProperties(properties);
                configuration.addAnnotatedClass(Student.class);
                sessionFactory = configuration.buildSessionFactory();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sessionFactory;
    }
}
