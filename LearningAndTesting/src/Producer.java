import java.sql.Connection;

public class Producer implements Runnable{
    private DBConnections dbConnections;
    private DBConnection dbConnection;
    public Producer(DBConnections dbConnections,DBConnection dbConnection){
        this.dbConnection=dbConnection;
        this.dbConnections=dbConnections;
    }
    @Override
    public void run() {
        while (true) {
            Connection connection= dbConnection.getConnection();
            try {
                dbConnections.produce(connection);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}