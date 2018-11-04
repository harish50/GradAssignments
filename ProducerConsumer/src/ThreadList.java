import java.util.ArrayList;

public class ThreadList {
    private ArrayList<Long> list = new ArrayList<>();

    public synchronized void add(long threadName) {
        list.add(threadName);
    }

    public boolean isThreadConsumedTwoTimes() {
        int size = list.size();
        if (size >= 2) {
            return list.get(size - 1) == list.get(size - 2);
        }
        return false;
    }

    public void reset() {
        list.clear();
    }

}
