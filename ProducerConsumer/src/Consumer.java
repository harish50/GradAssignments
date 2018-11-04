import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.Thread.sleep;

public class Consumer implements Runnable {
    private SharedDbConnections sharedDbConnections;
    private ThreadList threadList;

    public Consumer(SharedDbConnections sharedDbConnections, ThreadList threadList) {

        this.sharedDbConnections = sharedDbConnections;
        this.threadList = threadList;
    }

    public void run() {
        while (true) {
            int count = 0;
            Connection connection = null;
            try {
                if (threadList.isThreadConsumedTwoTimes()) {
                    threadList.reset();
                    sleep(5000);
                }
                connection = sharedDbConnections.consume();
                threadList.add(Thread.currentThread().getId());
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
