
import java.util.*;
import java.io.*;

public class lab5task2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int nodeCount = Integer.parseInt(tokenizer.nextToken());
        int edgeCount = Integer.parseInt(tokenizer.nextToken());
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int index = 0;
        while (index <= nodeCount) {
            adjacencyList.add(new ArrayList<>());
            index++;
        }
        int[] source = new int[edgeCount];
        int[] target = new int[edgeCount];
        tokenizer = new StringTokenizer(reader.readLine());
        index = 0;
        while (index < edgeCount) {
            source[index] = Integer.parseInt(tokenizer.nextToken());
            index++;
        }
        tokenizer = new StringTokenizer(reader.readLine());
        index = 0;
        while (index < edgeCount) {
            target[index] = Integer.parseInt(tokenizer.nextToken());
            index++;
        }
        index = 0;
        while (index < edgeCount) {
            if (source[index] != target[index]) {
                adjacencyList.get(source[index]).add(target[index]);
                adjacencyList.get(target[index]).add(source[index]);
            }
            index++;
        }
        index = 1;
        while (index <= nodeCount) {
            Collections.sort(adjacencyList.get(index));
            index++;
        }
        boolean[] visited = new boolean[nodeCount + 1];
        List<Integer> visitOrder = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                visitOrder.add(current);
                int neighborIndex = adjacencyList.get(current).size() - 1;
                while (neighborIndex >= 0) {
                    int neighbor = adjacencyList.get(current).get(neighborIndex);
                    if (!visited[neighbor]) {
                        if (neighbor > 0 && neighbor <= nodeCount) {
                            stack.push(neighbor);
                        }
                    }
                    neighborIndex--;
                }
            }
        }
        StringBuilder output = new StringBuilder();
        index = 0;
        while (index < visitOrder.size()) {
            output.append(visitOrder.get(index));
            if (index < visitOrder.size() - 1)
                output.append(" ");
            index++;
        }
        System.out.println(output.toString());
    }
}
