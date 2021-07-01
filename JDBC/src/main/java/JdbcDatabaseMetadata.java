import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class JdbcDatabaseMetadata {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            properties.load(loader.getResourceAsStream("database_connection.properties"));
            try (Connection connection = DriverManager.getConnection(
                    properties.getProperty("dbUrl"), properties)) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println(metaData.getDatabaseProductName());
                System.out.println(metaData.getDatabaseProductVersion());
                System.out.println(metaData.getDatabaseMajorVersion());
                ResultSet myres = metaData.getTables(null, null, null, null);
                while (myres.next()) {
                    if(myres.getString("TABLE_NAME").equalsIgnoreCase("employees"))
                    {
                        ResultSet columns=metaData.getColumns(null,null,
                                myres.getString("TABLE_NAME"),null);
                        while(columns.next()){
                            System.out.println(columns.getString("COLUMN_NAME"));
                        }
                        break;
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
