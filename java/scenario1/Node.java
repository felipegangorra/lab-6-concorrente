import java.util.Queue;

public class Node implements Runnable {
    private Queue taskQueue;
    private int id;

    public Node(Queue<Task> taskQueue, int id) {
        this.taskQueue = taskQueue;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            Task task = new Task();
            synchronized (taskQueue) {
                if (!taskQueue.isEmpty()) {
                    task = (Task) taskQueue.poll();
                } else {
                    task = null;
                }
            }

            if (task != null) {
                long startTime = System.currentTimeMillis();
                task.execute();
                long endTime = System.currentTimeMillis();
                long activeTime = endTime - startTime;
                long taskLife = endTime - task.getCreationTime();
                System.out.println("Nó " + id + " task processada " + task.getId() +
                        " | Tempo ativo: " + activeTime + " ms | Duração: " + taskLife + " ms");
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}