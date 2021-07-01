package com.github.runtime.exception.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

public class UpdateQueryEntity {
    public static void main(String[] args) {
        try {
            //Step 1 Create session factory with annotated class
            try (SessionFactory sessionFactory = new Configuration().configure().
                    addAnnotatedClass(Student.class).buildSessionFactory()) {
                //Step 2: Get Session
                Session session = sessionFactory.getCurrentSession();
                //Step 3: Start Transaction
                Transaction transaction = session.beginTransaction();
                //Step 4: Get query Interface with query
                Query query = session.createQuery("update Student set lastName=:lastname where id=:id");
                //Step 5: Set query parameters
                query.setParameter("lastname", "denial");
                query.setParameter("id", 1);
                //Step 5: Exeute the query
                int noOfRowEffected = query.executeUpdate();
                System.out.println("No Of Row Effected" + noOfRowEffected);
                //Step 6: commit the transaction
                transaction.commit();
                //Step 7: close the session
                session.close();

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
