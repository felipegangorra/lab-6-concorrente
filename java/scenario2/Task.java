import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Task implements Comparable<Task>{
    private static final AtomicLong counter = new AtomicLong(0);
    private long id;
    private long creationTime;
    private int priority;

    public Task(int priority) {
        this.id = counter.incrementAndGet();
        this.creationTime = System.currentTimeMillis();
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public int getPriority() {
        return priority;
    }

    public void execute() {
        try {
            long execDuration = 1000 + (long) (new Random().nextFloat() * (15000 - 1000));
            Thread.sleep(execDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

}