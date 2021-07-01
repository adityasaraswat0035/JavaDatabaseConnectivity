package com.github.runtime.exception.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteEntity {
    public static void main(String[] args) {
        try {
            //Step 1: Create a session factory
            try (SessionFactory sessionFactory = new Configuration().configure()
                    .addAnnotatedClass(Student.class).buildSessionFactory()) {
                //Step 2: Create a session
                Session session=sessionFactory.getCurrentSession();
                //Step 3: Start a transaction
                Transaction transaction=session.beginTransaction();
                //Step 4: fetch the object need to be deleted
                Student student=session.find(Student.class,1);
                //Step5: delete the object from session
                session.delete(student);
                //step 6: commit the changes
                transaction.commit();
                //Step 7: close the session
                session.close();
            }

        } catch (Exception ex) {

        }
    }
}
