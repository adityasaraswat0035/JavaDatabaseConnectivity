import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class StoredProcedureWithInputParameter {
    public static void main(String[] args) {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Properties properties = new Properties();
            properties.load(classLoader.getResourceAsStream("database_connection.properties"));
            try (Connection connection = DriverManager.getConnection(
                    properties.getProperty("dbUrl"), properties)) {
//                CallableStatement statement = connection.prepareCall("{call GetAllEmployees}");
//                ResultSet myrs = statement.executeQuery();
//                while (myrs.next()){
//                    System.out.println("Id                      :"+myrs.getString("Id"));
//                    System.out.println("Last Name               :"+myrs.getString("last_name"));
//                    System.out.println("First Name              :"+myrs.getString("first_name"));
//                    System.out.println("Email                   :"+myrs.getString("email"));
//
//                }

                CallableStatement statement2=connection.prepareCall("{call GetEmployeesByDepartment(?)}");
                statement2.setString(1,"HR");
                ResultSet myrs2 = statement2.executeQuery();
                while (myrs2.next()){
                    System.out.println("Id                      :"+myrs2.getString("Id"));
                    System.out.println("Last Name               :"+myrs2.getString("last_name"));
                    System.out.println("First Name              :"+myrs2.getString("first_name"));
                    System.out.println("Email                   :"+myrs2.getString("email"));

                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
