
import java.util.*;

public class lab4task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodeCount = scanner.nextInt();
        int edgeCount = scanner.nextInt();

        int[] sourceNodes = new int[edgeCount];
        int[] destinationNodes = new int[edgeCount];
        int[] weights = new int[edgeCount];

        readArray(scanner, sourceNodes);
        readArray(scanner, destinationNodes);
        readArray(scanner, weights);

        List<List<String>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++)
            adjacencyList.add(new ArrayList<>());
        fillAdjacencyList(adjacencyList, sourceNodes, destinationNodes, weights);
        printAdjacencyList(adjacencyList);
    }

    static void readArray(Scanner scanner, int[] values) {
        for (int i = 0; i < values.length; i++)
            values[i] = scanner.nextInt();
    }

    static void fillAdjacencyList(List<List<String>> adjacencyList, int[] sources, int[] destinations, int[] weights) {
        for (int i = 0; i < sources.length; i++) {
            int sourceIndex = sources[i] - 1;
            int destination = destinations[i];
            int weight = weights[i];
            adjacencyList.get(sourceIndex).add("(" + destination + "," + weight + ")");
        }
    }

    static void printAdjacencyList(List<List<String>> adjacencyList) {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print((i + 1) + ":");
            if (!adjacencyList.get(i).isEmpty()) {
                System.out.print(" ");
                System.out.println(String.join(" ", adjacencyList.get(i)));
            } else {
                System.out.println();
            }
        }
    }
}
