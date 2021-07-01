import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class StoredProcedureWithResultSet {
    public static void main(String[] args) {
        try{ ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Properties properties = new Properties();
            properties.load(classLoader.getResourceAsStream("database_connection.properties"));
            try (Connection connection = DriverManager.getConnection(
                    properties.getProperty("dbUrl"), properties)) {
                CallableStatement statement = connection.prepareCall("{call GetAllEmployees}");
                statement.execute();
                ResultSet myrs =statement.getResultSet();
                while (myrs.next()){
                    System.out.println("Id                      :"+myrs.getString("Id"));
                    System.out.println("Last Name               :"+myrs.getString("last_name"));
                    System.out.println("First Name              :"+myrs.getString("first_name"));
                    System.out.println("Email                   :"+myrs.getString("email"));

                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
