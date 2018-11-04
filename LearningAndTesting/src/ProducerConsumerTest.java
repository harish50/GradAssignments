
public class ProducerConsumerTest {
    public static void main(String[] args) {
        DBConnections dbConnections= new DBConnections();
        DBConnection dbConnection= new DBConnection();
        Producer producer= new Producer(dbConnections,dbConnection);
        ThreadList threadList=new ThreadList();
        Consumer consumer=new Consumer(dbConnections,producer,threadList);

        Thread thread1= new Thread(producer);
        Thread thread2= new Thread(new Consumer(dbConnections,producer,threadList));
        Thread thread3= new Thread(new Consumer(dbConnections,producer,threadList));
        Thread thread4= new Thread(new Consumer(dbConnections,producer,threadList));
        Thread thread5= new Thread(new Consumer(dbConnections,producer,threadList));
        Thread thread6= new Thread(consumer);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}
