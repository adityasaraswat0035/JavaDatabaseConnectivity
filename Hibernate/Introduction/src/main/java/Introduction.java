import com.github.runtime.exception.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Introduction {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try {
            //Step 1 get a factory instance heavy weight object so create once in app liftime
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();
            //Step 2: Get Hibernated Session from session factory
            Session session = factory.getCurrentSession();
            //Step 3: Create an entity
            Student student1 = new Student();
            student1.setFirstName("Jhon");
            student1.setLastName("Doe");
            Student student2 = new Student();
            student2.setFirstName("Mary");
            student2.setLastName("Public");
            Student student3 = new Student();
            student3.setFirstName("Bonita");
            student3.setLastName("AppleBum");
            //Step 4: start a transaction
            Transaction transaction = session.beginTransaction();
            //Step 5: Save the object to the session
            session.save(student1); //till this point entity is not added in DB
            session.save(student2);
            session.save(student3);
            //Step 6: commit transaction changes so reflect in database
            transaction.commit();
            System.out.println(student1 + " Created");
            System.out.println(student2 + " Created");
            System.out.println(student3 + " Created");
            //Step 7: close the session
            session.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (factory != null)
                //Step 8: close the session factory
                factory.close();
        }
    }
}
