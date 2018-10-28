import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {
    @Test
    public void connectionLimitTest() throws SQLException, ConnectionPoolLimitReached {
        ConnectionPool connectionPool = ConnectionPool.create("jdbc:postgresql://localhost:5432/postgis_test", "sharish", "");
        for (int counter = 0; counter < 5; counter++) {
            Connection connection = connectionPool.getConnection();
            Assert.assertTrue(connection.isValid(1));
        }
        try {
            Connection connection = connectionPool.getConnection();
        } catch (ConnectionPoolLimitReached cple) {
            System.out.printf("Pool has no available connection");
        }
        connectionPool.clearConnections();

    }

    @Test
    public void connectionPoolReturnConnectionTest() throws SQLException, ConnectionPoolLimitReached {
        ConnectionPool connectionPool = ConnectionPool.create("jdbc:postgresql://localhost:5432/postgis_test", "sharish", "");
        Connection arr[] = new Connection[5];
        for (int counter = 0; counter < 5; counter++) {
            arr[counter] = connectionPool.getConnection();
        }
        Assert.assertTrue(connectionPool.returnConnection(arr[2]));
        Assert.assertFalse(connectionPool.returnConnection(arr[2]));
    }

}
