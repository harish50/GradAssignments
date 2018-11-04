import java.sql.Connection;
import java.util.ArrayList;

public class DBConnections {
    private ArrayList<Connection> connectionsList=new ArrayList<>();
    public synchronized void produce(Connection connection) throws InterruptedException {
        while (this.connectionsList.size()==25){
            wait();
        }
        System.out.println("Produced"+this.connectionsList.size());
        this.connectionsList.add(connection);
        notifyAll();
    }

    public synchronized Connection consume() throws InterruptedException {
        while (this.connectionsList.size()<=0){
            wait();
        }
        Connection connection= this.connectionsList.get(0);
        this.connectionsList.remove(connection);
        System.out.println(Thread.currentThread().getName()+" Consumed ");
        notifyAll();
        return connection;
    }

}
