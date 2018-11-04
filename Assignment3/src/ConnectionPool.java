import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private String url;
    private String username;
    private String password;
    private static int maxSize = 5;
    private static ConnectionPool connectionPool;
    private List<Connection> availableConnections;
    private List<Connection> usedConnections = new ArrayList<>();

    private ConnectionPool(String url, String username, String password, List pool) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.availableConnections = pool;
    }

    public static ConnectionPool create(String url, String username, String password) throws SQLException {
        if (connectionPool == null) {
            List<Connection> pool = new ArrayList<>(maxSize);
            for (int counter = 0; counter < maxSize; counter++) {
                Connection connection = DriverManager.getConnection(url, username, password);
                pool.add(connection);
            }
            connectionPool = new ConnectionPool(url, username, password, pool);
            return connectionPool;
        } else {
            return connectionPool;
        }
    }

    public Connection getConnection() throws SQLException, ConnectionPoolLimitReached {
        if (this.usedConnections.size() < maxSize) {
            Connection connection = availableConnections.remove(availableConnections.size() - 1);
            usedConnections.add(connection);
            return connection;
        } else {
            throw new ConnectionPoolLimitReached();
        }
    }

    public boolean returnConnection(Connection connection) {
        availableConnections.add(connection);
        return usedConnections.remove(connection);
    }

    public void clearConnections() {
        for (Connection connection : usedConnections) {
            availableConnections.add(connection);
        }
        for (Connection connection : availableConnections) {
            usedConnections.remove(connection);
        }
    }

}
