import java.util.Queue;
import java.util.LinkedList;

public class TaskProducer implements Runnable {
    private Queue taskQueue;
    private int id;

    public TaskProducer(Queue<Task> taskQueue, int id) {
        this.taskQueue = taskQueue;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                Task task = new Task();
                synchronized (taskQueue) {
                    taskQueue.add(task);
                    System.out.println("O Produtor " + id + " produziu a task " + task.getId());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}