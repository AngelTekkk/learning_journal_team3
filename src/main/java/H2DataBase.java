import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2DataBase {
    public static void main(String[]args){
        String url = "jdbc:h2:tcp://localhost/~/testdb";
        String user ="sa";
        String password ="";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()){


            String dropTableSQL = "DROP TABLE IF EXISTS users";
            stmt.execute(dropTableSQL);
            System.out.println("Tabelle gelöscht!");


            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "first_name VARCHAR(255), " +
                    "last_name VARCHAR(255), " +
                    "user_name VARCHAR(255), " +
                    "email VARCHAR(255))";
            stmt.execute(createTableSQL);
            System.out.println("Tabelle erstellt");


            String insertSQL = "INSERT INTO users (name, email) VALUES ('Alice', 'alice@example.com')";
            stmt.executeUpdate(insertSQL);
            System.out.println("Daten eingefügt!");

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
