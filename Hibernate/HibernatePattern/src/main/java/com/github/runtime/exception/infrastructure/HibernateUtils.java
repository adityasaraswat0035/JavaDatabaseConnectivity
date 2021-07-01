package com.github.runtime.exception.infrastructure;

import com.github.runtime.exception.entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                //Create registry
                registry = new StandardServiceRegistryBuilder().configure().build();
                //Create metadata
                MetadataSources source = new MetadataSources(registry);
                source.addAnnotatedClass(Student.class);

                //Create metadata
                Metadata metadata = source.getMetadataBuilder().build();
                //Create sessionfactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception ex) {
                ex.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void Shutdown() {
        if (registry != null)
            StandardServiceRegistryBuilder.destroy(registry);
    }
}
