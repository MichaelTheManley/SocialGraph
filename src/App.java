import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        String url = "jdbc:postgresql://localhost:5432/thallodb";
        String user = "manley_michael";
        String password = "NoTimeForCaution414375";

        Connection conn = null;
        Statement stmt = null;
        ResultSet result = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            //String insert_query = "INSERT INTO Users(\"username\", \"email\", \"created_at\", \"password_hash\", \"display_name\")" +
            //                      "VALUES ('mike', 'mike@email.com', '2021-01-01', 'password', 'Mike')";

            stmt = conn.createStatement();
            //stmt.executeUpdate(insert_query);

            String sql_query = "SELECT * FROM Users";

            result = stmt.executeQuery(sql_query);

            if (result.next()) {
                System.out.println("Username: " + result.getString("username"));
            }

            // while (result.next()) {
            //     System.out.println("Username: " + result.getString("username"));
            // }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
