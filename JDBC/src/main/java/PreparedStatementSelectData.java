import java.sql.*;
import java.util.Properties;

public class PreparedStatementSelectData {
    public static void main(String[] args) {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Properties properties = new Properties();
            properties.load(classLoader.getResourceAsStream("database_connection.properties"));
            try (Connection connection = DriverManager.getConnection(
                    properties.getProperty("dbUrl"), properties)) {
                PreparedStatement statement = connection.prepareStatement("Select * from Person.Person");
                ResultSet myrs = statement.executeQuery();
                while (myrs.next()) {
                    System.out.println("***************************************************************************");
                    System.out.println("FirstName           :" + myrs.getString("FirstName"));
                    System.out.println("MiddleName           :" + myrs.getString("MiddleName"));
                    System.out.println("LastName           :" + myrs.getString("LastName"));
                    System.out.println("ModifiedDate           :" + myrs.getDate("ModifiedDate"));
                    System.out.println("***************************************************************************");
                }
                myrs = statement.executeQuery();
                System.out.println("Again!!!");
                while (myrs.next()) {
                    System.out.println("***************************************************************************");
                    System.out.println("FirstName           :" + myrs.getString("FirstName"));
                    System.out.println("MiddleName           :" + myrs.getString("MiddleName"));
                    System.out.println("LastName           :" + myrs.getString("LastName"));
                    System.out.println("ModifiedDate           :" + myrs.getDate("ModifiedDate"));
                    System.out.println("***************************************************************************");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
