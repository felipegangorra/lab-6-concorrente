import java.util.Queue;
import java.util.LinkedList;

public class ScenarioBase {
    public static void main(String[] args) {
        Queue taskQueue = new LinkedList<>();

        // criando e iniciando TaskProducer
        for (int i = 1; i <= 5; i++) {
            new Thread(new TaskProducer(taskQueue, i)).start();
        }

        // criando e iniciando os nós
        for (int i = 1; i <= 3; i++) {
            new Thread(new Node(taskQueue, i)).start();
        }

        System.out.println("Scenario Base do Lab06 iniciando com produtores e nós!");
    }
}