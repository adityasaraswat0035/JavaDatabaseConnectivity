package com.github.runtime.exception.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

public class QueryingEntity {
    public static void main(String[] args) {
        try {
            try (SessionFactory sessionFactory = new Configuration()
                     .configure()
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory()) {
                Session session = sessionFactory.getCurrentSession();
                Transaction transaction= session.beginTransaction();
                Query query = session.createQuery("from Student s where s.id=:id and firstName=:firstname");
//              Query query = session.createQuery("from Student s where  firstName like :firstname");

                query.setParameter("id", 3);
                query.setParameter("firstname","Jhon");
                Object studentObj = query.getSingleResult();
                if (studentObj != null) {
                    Student student = (Student) studentObj;
                    System.out.println(student);
                }
                transaction.commit();
                session.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
