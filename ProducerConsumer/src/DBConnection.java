import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private String db_url = "jdbc:postgresql://localhost:5432/postgis_test";
    private String username = "sharish";
    private String password = "";

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(db_url, username, password);
            ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
