import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.Thread.sleep;

public class Consumer implements Runnable {
    private SharedDbConnections sharedDbConnections;
    private ConsumerMonitor consumerMonitor;

    public Consumer(SharedDbConnections sharedDbConnections, ConsumerMonitor consumerMonitor) {

        this.sharedDbConnections = sharedDbConnections;
        this.consumerMonitor= consumerMonitor;
    }

    public void run() {
        while (true) {
            int count = 0;
            Connection connection = null;
            try {
                if (consumerMonitor.isThreadSelfish(Thread.currentThread().getId())) {
                    sleep(5000);
                }
                connection = sharedDbConnections.consume();
                count += 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
