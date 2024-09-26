import java.util.PriorityQueue;

public class ScenarioBase {
public static void main(String[] args) {
PriorityQueue taskQueue = new PriorityQueue<>();

    new Thread(new TaskProducer(taskQueue, 1, 0, 13000)).start();
    new Thread(new TaskProducer(taskQueue, 2, 1, 7000)).start();
    new Thread(new TaskProducer(taskQueue, 3, 2, 3000)).start();

    for (int i = 1; i <= 3; i++) {
        new Thread(new Node(taskQueue, i)).start();
    }

    System.out.println("Scenario Base do Lab06 iniciando com produtores e nós!");
}
}