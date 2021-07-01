package com.github.runtime.exception;

import com.github.runtime.exception.entities.Student;
import com.github.runtime.exception.infrastructure.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class FirstPatternTesting {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Aditya");
        student.setLastName("Saraswat");
        Transaction transaction = null;
        try (SessionFactory sessionFactory= HibernateUtils.getSessionFactory()){
            Session session=sessionFactory.getCurrentSession();
            transaction=session.beginTransaction();
            session.save(student);
            transaction.commit();
            session.close();
        }
    }
}
