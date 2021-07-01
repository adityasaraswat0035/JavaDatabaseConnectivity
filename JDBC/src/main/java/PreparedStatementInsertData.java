import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class PreparedStatementInsertData {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            properties.load(classLoader.getResourceAsStream("database_connection.properties"));
            try(Connection connection= DriverManager.getConnection(properties.getProperty("dbUrl"),properties)){
                PreparedStatement insertStatement=connection.prepareStatement(
                        "Insert into Employee(firstname,lastname,age) values(?,?,?)");
                insertStatement.setString(1,"Aditya");
                insertStatement.setString(2,"Saraswat");
                insertStatement.setInt(3,28);
               int noOfInsetedRecord= insertStatement.executeUpdate();
               System.out.println("No Of Inserted Records "+noOfInsetedRecord);
               noOfInsetedRecord=insertStatement.executeUpdate();
               System.out.println("No Of Inserted Records "+noOfInsetedRecord);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
