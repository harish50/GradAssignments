public enum Singleton {
    INSTANCE;
    private int value;

    public void setValue(int number) {

        this.value = number;
    }

    public int getValue() {
        return this.value;
    }
}
