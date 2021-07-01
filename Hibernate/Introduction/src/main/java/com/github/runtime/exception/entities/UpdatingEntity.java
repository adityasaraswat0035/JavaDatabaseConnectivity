package com.github.runtime.exception.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdatingEntity {
    public static void main(String[] args) {
        try {
            try(SessionFactory sessionFactory=new Configuration().configure()
                    .addAnnotatedClass(Student.class).buildSessionFactory()){

                //Step 1: get session from session factory
                Session session=sessionFactory.getCurrentSession();
                //Step 2: Start transaction
                Transaction transaction=session.beginTransaction();
                //Get Student with Id=1
                Student student=session.find(Student.class,1);
                student.setLastName("Jack");
                transaction.commit();
                session.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
