import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Introduction {
    public static void main(String[] args) {
        try {
            //Get Current class loader
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();

            //Step 1: Get a connection for Database
            Properties properties = new Properties();
            properties.load(classloader.getResourceAsStream("database_connection.properties"));
            try (Connection connection = DriverManager.getConnection(properties.getProperty("dbUrl"), properties)) {
                //Step 2: Create a statement object
                Statement statement = connection.createStatement();
                //Step 3: Execute Query
                ResultSet myrs = statement.executeQuery("SELECT * FROM Person.Person");
                //Step 4: Process the result set
                while (myrs.next()) {
                    System.out.println("***************************************************************************");
                    System.out.println("FirstName           :" + myrs.getString("FirstName"));
                    System.out.println("MiddleName           :" + myrs.getString("FirstName"));
                    System.out.println("LastName           :" + myrs.getString("FirstName"));
                    System.out.println("ModifiedDate           :" + myrs.getDate("ModifiedDate"));
                    System.out.println("***************************************************************************");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
