import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.Thread.sleep;

public class Consumer extends Thread {
    private DBConnections dbConnections;
    private Producer producer;
    private ThreadList threadList;

    public Consumer(DBConnections dbConnections,Producer producer,ThreadList threadList) {

        this.dbConnections = dbConnections;
        this.producer=producer;
        this.threadList=threadList;
    }
    public void run() {
            while (true) {
                int count = 0;
                Connection connection = null;
                try {
                    if(threadList.isThreadConsumedTwoTimes()){
                        threadList.reset();
                        sleep(5000);
                    }
                    connection = dbConnections.consume();
                    threadList.add(this.getId());
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
