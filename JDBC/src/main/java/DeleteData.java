import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class DeleteData {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            properties.load(classLoader.getResourceAsStream("database_connection.properties"));
            try (Connection connection = DriverManager.getConnection(
                    properties.getProperty("dbUrl"), properties)) {
                Statement statement = connection.createStatement();
                int noOfRecordDeleted = statement.executeUpdate("Delete from Employee where id=1");
                System.out.println("No of Record Delete: "+noOfRecordDeleted);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
