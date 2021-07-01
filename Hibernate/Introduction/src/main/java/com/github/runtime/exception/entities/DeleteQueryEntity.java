package com.github.runtime.exception.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

public class DeleteQueryEntity {
    public static void main(String[] args) {
        try {
            //step 1: Create session factory
            try (SessionFactory sessionFactory = new Configuration().configure()
                    .addAnnotatedClass(Student.class).buildSessionFactory()) {
                //step2: Get session
                Session session = sessionFactory.getCurrentSession();
                //step 3: start a transaction
                Transaction transaction = session.beginTransaction();
                //Step 4: get query interface
                Query query = session.createQuery("delete from Student where id=:id");
                //Step 5: set query parameter
                query.setParameter("id", 2);
                //step 5: execute query
                int noOfRecordDeleted = query.executeUpdate();
                System.out.println("Deleted Records: " + noOfRecordDeleted);
                //Step 6: Commit the transaction
                transaction.commit();
                //Step 7: close the session
                session.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
