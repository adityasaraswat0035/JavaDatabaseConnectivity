import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Properties;

public class StoredProcedureWithOutputParameter {
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            props.load(loader.getResourceAsStream("database_connection.properties"));
            try (Connection connection = DriverManager.getConnection(props.getProperty("dbUrl"), props)) {
                CallableStatement countProcedure = connection.prepareCall("{call GetEmployeesCount(?)}");
                countProcedure.registerOutParameter(1, Types.INTEGER);
                countProcedure.execute();
                System.out.println("Total No Of Records :" + countProcedure.getInt(1));
            }
        } catch (Exception ex) {

        }
    }
}
