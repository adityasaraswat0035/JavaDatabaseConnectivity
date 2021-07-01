import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class UpdateData {
    public static void main(String[] args) {
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            Properties properties = new Properties();
            properties.load(loader.getResourceAsStream("database_connection.properties"));
            try (Connection connection = DriverManager.getConnection(properties.getProperty("dbUrl"), properties)) {
                Statement queryStatement = connection.createStatement();
                int noOfRowUpdated = queryStatement.executeUpdate("Update Employee set age=21 where Id=1");
                System.out.println("No of rows updated :" + noOfRowUpdated);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
