import java.sql.Connection;

public class Producer implements Runnable {
    private SharedDbConnections sharedDbConnections;
    private DBConnection dbConnection;

    public Producer(SharedDbConnections sharedDbConnections, DBConnection dbConnection) {
        this.dbConnection = dbConnection;
        this.sharedDbConnections = sharedDbConnections;
    }

    @Override
    public void run() {
        while (true) {
            Connection connection = dbConnection.getConnection();
            try {
                sharedDbConnections.produce(connection);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}