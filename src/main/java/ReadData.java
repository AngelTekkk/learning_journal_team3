import java.sql.*;
public class ReadData {
    public static void main(String[]args){
        String url = "jdbc:h2:tcp://localhost/~/testdb";
        String user = "sa";
        String password ="";

        try (Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users")){
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Email: " + rs.getString("email"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
