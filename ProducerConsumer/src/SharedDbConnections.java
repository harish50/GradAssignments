import java.sql.Connection;
import java.util.ArrayList;

public class SharedDbConnections {
    private ArrayList<Connection> connectionsList = new ArrayList<>();
    private int capacity=25;
    public synchronized void produce(Connection connection) throws InterruptedException {
        while (this.connectionsList.size() >capacity) {
            wait();
        }
        System.out.println("Produced" + this.connectionsList.size());
        this.connectionsList.add(connection);
        notifyAll();
    }

    public synchronized Connection consume() throws InterruptedException {
        while (this.connectionsList.size() <1) {
            wait();
        }
        Connection connection = this.connectionsList.get(0);
        this.connectionsList.remove(connection);
        System.out.println(Thread.currentThread().getName() + " Consumed ");
        notifyAll();
        return connection;
    }

}
