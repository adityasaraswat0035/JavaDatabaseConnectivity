import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class PreparedStatementUpdateData {
    public static void main(String[] args) {
        try {

            Properties properties = new Properties();
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            properties.load(classLoader.getResourceAsStream("database_connection.properties"));
            try (Connection connection = DriverManager.getConnection(
                    properties.getProperty("dbUrl"), properties)) {
                PreparedStatement statement = connection.prepareStatement("Update Employee set age=? where firstname=?");
                statement.setInt(1, 21);
                statement.setString(2, "Aditya");
                int noOfRowUpdated = statement.executeUpdate();
                System.out.println("No of Row Updated : " + noOfRowUpdated);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
