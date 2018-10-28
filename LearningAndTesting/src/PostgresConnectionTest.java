import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;


public class PostgresConnectionTest {
    @Test
    public void testConnection() throws SQLException {
        Assert.assertTrue(PostgresConnection.getConnection().isValid(1));
    }

}
