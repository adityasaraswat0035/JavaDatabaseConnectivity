import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class JdbcTransaction {
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            props.load(loader.getResourceAsStream("database_connection.properties"));
            try (Connection conn = DriverManager.getConnection(
                    props.getProperty("dbUrl"), props)) {
                conn.setAutoCommit(false);
                PreparedStatement statement = conn.
                        prepareStatement("Delete from employees where department=?");
                statement.setString(1, "HR");
                int noOfRowsEffected = statement.executeUpdate();
                System.out.println("No of rows effected : " + noOfRowsEffected);
                System.out.println("Commit Transaction? yes/no");
                Scanner scanner = new Scanner(System.in);
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("yes")) {
                    conn.commit();
                } else {
                    conn.rollback();
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
