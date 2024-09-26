import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Task {
    private static final AtomicLong counter = new AtomicLong(0);
    private long id;
    private long creationTime;

    public Task() {
        this.id = counter.incrementAndGet();
        this.creationTime = System.currentTimeMillis();
    }

    public long getId() {
        return id;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void execute() {
        try {
            long execDuration = 1000 + (long) (new Random().nextFloat() * (15000 - 1000));
            Thread.sleep(execDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}