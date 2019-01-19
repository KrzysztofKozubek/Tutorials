package scope;

public class Counter {

    private final int id;
    private static int count = 0;

    public Counter() {
        synchronized (this) {
            count++;
            id = count;
        }
    }

    @Override
    public String toString() {
        return "Counter{" +
                "count: " + count + ", " +
                "id: " + id +
                "}";
    }
}
