
public class ProducerConsumerTest {
    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
        ThreadList threadList = new ThreadList();
        SharedDbConnections sharedDbConnections = new SharedDbConnections();
        Producer producer = new Producer(sharedDbConnections, dbConnection);

        Thread producerThread = new Thread(producer);
        Thread consumer1 = new Thread(new Consumer(sharedDbConnections, threadList));
        Thread consumer2 = new Thread(new Consumer(sharedDbConnections, threadList));
        Thread consumer3 = new Thread(new Consumer(sharedDbConnections, threadList));
        Thread consumer4 = new Thread(new Consumer(sharedDbConnections, threadList));
        Thread consumer5 = new Thread(new Consumer(sharedDbConnections, threadList));
        producerThread.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        consumer5.start();
    }
}
