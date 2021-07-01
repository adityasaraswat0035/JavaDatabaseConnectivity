package org.exmaple;

import org.exmaple.entities.Address;
import org.exmaple.entities.Employee;
import org.exmaple.infrastructure.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestProgram {
    public static void main(String[] args) {
        try {
            //Step 1: Get session factory
            try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory()) {
                Session session = sessionFactory.getCurrentSession();
                //Create new Entity
                Address address = new Address();
                address.setAddressLine1("xyz Street 1");
                address.setAddressLine2("XYZ Street 2");
                address.setCity("New York");
                address.setCountry("United State");
                address.setZipCode("1234-122");
                Employee employee = new Employee();
                employee.setFirstname("Aditya");
                employee.setLastname("Aditya");
                employee.setSalary(120.0d);
                employee.setAddress(address);
                address.setEmployee(employee);
                //Step 2: Start Transaction
                Transaction transaction = session.beginTransaction();
                //Step 3: Persist entities into session
                session.save(employee);
                //Step 4: Commit the transaction
                transaction.commit();
                session.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
