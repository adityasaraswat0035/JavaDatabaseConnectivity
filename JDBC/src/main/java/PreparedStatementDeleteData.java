import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class PreparedStatementDeleteData {
    public static void main(String[] args) {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Properties properties = new Properties();
            properties.load(classLoader.getResourceAsStream("database_connection.properties"));
            try (Connection connection = DriverManager.getConnection(
                    properties.getProperty("dbUrl"), properties)) {
                PreparedStatement deleteStatement = connection.prepareStatement("Delete from employee where firstname=?");
                deleteStatement.setString(1,"Aditya");
                int noOfDeletedRow = deleteStatement.executeUpdate();
                System.out.println("No of Deleted Row :" + noOfDeletedRow);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
