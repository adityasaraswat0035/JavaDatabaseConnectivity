import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class InsertData {
    public static void main(String[] args) {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Properties properties = new Properties();
            properties.load(classLoader.getResourceAsStream("database_connection.properties"));
            try (Connection connection = DriverManager.getConnection(properties.getProperty("dbUrl"), properties)) {
                Statement statement = connection.createStatement();
                int noOfStatement = statement.executeUpdate("Insert into Employee(firstname,lastname,age) values('Aditya','Saraswat',26)");
                System.out.println("total no of rows effected " + noOfStatement);
                System.out.println("Inserted Successfully ");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
