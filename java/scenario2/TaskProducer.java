import java.util.PriorityQueue;

public class TaskProducer implements Runnable {
private PriorityQueue taskQueue;
private int id;
private int priority;
private long interval;

public TaskProducer(PriorityQueue<Task> taskQueue, int id, int priority, long interval) {
    this.taskQueue = taskQueue;
    this.id = id;
    this.priority = priority;
    this.interval = interval;
}

@Override
public void run() {
    while (true) {
        try {
            Thread.sleep(interval);
            Task task = new Task(priority);
            synchronized (taskQueue) {
                taskQueue.add(task);
                System.out.println("O Produtor " + id + " produziu a task " + task.getId() + " com prioridade " + priority);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            break;
        }
    }
}
}