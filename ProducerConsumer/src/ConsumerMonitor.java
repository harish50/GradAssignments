import java.util.ArrayList;

public class ConsumerMonitor {
    private long lastThreadId=-1;
    private int threadCount=0;
    public synchronized boolean isThreadSelfish(long currentThreadId) {
        if (lastThreadId==currentThreadId) {
            threadCount+=1;
        }
        else {
            lastThreadId=currentThreadId;
            threadCount=1;
        }
        return threadCount>2;
    }

}
