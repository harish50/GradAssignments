public class ConnectionPoolLimitReached extends Exception {
    public ConnectionPoolLimitReached() {
        super("Connectionpool has no available connection");
    }

}
