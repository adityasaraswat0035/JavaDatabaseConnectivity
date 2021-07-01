package com.github.runtime.exception.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RetrieveEntity {
    public static void main(String[] args) {
        try {
            Logger.getLogger("org.hibernate").setLevel(Level.WARNING);
            //Step 1: Create session factory
            try (SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory()) {
                //Step 2: get session
                Session session = sessionFactory.getCurrentSession();
                //Step 3: start a transaction
                 Transaction transaction= session.beginTransaction();
                //Step 4: Retrieve student by id
                int studentId = 3;
                Student student = session.find(Student.class, studentId);
                //Step 4: Commit the transaction
                transaction.commit();
                if (student != null) {
                    System.out.println(student);
                } else {
                    System.out.println("Not found");
                }
                session.close();
            }

        } catch (Exception ex) {

        }
    }
}
