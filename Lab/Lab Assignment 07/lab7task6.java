import java.io.*;
import java.util.*;

public class lab7task6 {
    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int nodeCount = Integer.parseInt(tokenizer.nextToken());
        int edgeCount = Integer.parseInt(tokenizer.nextToken());
        int source = Integer.parseInt(tokenizer.nextToken());
        int destination = Integer.parseInt(tokenizer.nextToken());

        ArrayList<Edge>[] adjacencyList = new ArrayList[nodeCount + 1];
        for (int nodeIndex = 1; nodeIndex <= nodeCount; nodeIndex++) {
            adjacencyList[nodeIndex] = new ArrayList<>();
        }

        int[] edgeFrom = new int[edgeCount];
        int[] edgeTo = new int[edgeCount];
        int[] edgeWeight = new int[edgeCount];

        for (int edgeIndex = 0; edgeIndex < edgeCount; edgeIndex++) {
            tokenizer = new StringTokenizer(reader.readLine());
            edgeFrom[edgeIndex] = Integer.parseInt(tokenizer.nextToken());
            edgeTo[edgeIndex] = Integer.parseInt(tokenizer.nextToken());
            edgeWeight[edgeIndex] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int edgeIndex = 0; edgeIndex < edgeCount; edgeIndex++) {
            int fromNode = edgeFrom[edgeIndex];
            int toNode = edgeTo[edgeIndex];
            int weight = edgeWeight[edgeIndex];

            adjacencyList[fromNode].add(new Edge(toNode, weight));
            adjacencyList[toNode].add(new Edge(fromNode, weight));
        }

        long[] shortestDistance = new long[nodeCount + 1];
        long[] secondShortestDistance = new long[nodeCount + 1];
        Arrays.fill(shortestDistance, Long.MAX_VALUE);
        Arrays.fill(secondShortestDistance, Long.MAX_VALUE);

        PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(entry -> entry[0]));

        shortestDistance[source] = 0;
        priorityQueue.add(new long[] { 0, source });

        while (!priorityQueue.isEmpty()) {
            long[] currentEntry = priorityQueue.poll();
            long currentDistance = currentEntry[0];
            int currentNode = (int) currentEntry[1];

            if (currentDistance > secondShortestDistance[currentNode]) {
                continue;
            }

            for (Edge edge : adjacencyList[currentNode]) {
                long newDistance = currentDistance + edge.weight;
                int neighbor = edge.target;

                if (newDistance < shortestDistance[neighbor]) {
                    secondShortestDistance[neighbor] = shortestDistance[neighbor];
                    shortestDistance[neighbor] = newDistance;

                    priorityQueue.add(new long[] { shortestDistance[neighbor], neighbor });
                    if (secondShortestDistance[neighbor] != Long.MAX_VALUE) {
                        priorityQueue.add(new long[] { secondShortestDistance[neighbor], neighbor });
                    }
                } else if (newDistance > shortestDistance[neighbor] && newDistance < secondShortestDistance[neighbor]) {
                    secondShortestDistance[neighbor] = newDistance;
                    priorityQueue.add(new long[] { secondShortestDistance[neighbor], neighbor });
                }
            }
        }

        if (secondShortestDistance[destination] == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(secondShortestDistance[destination]);
        }
    }
}
