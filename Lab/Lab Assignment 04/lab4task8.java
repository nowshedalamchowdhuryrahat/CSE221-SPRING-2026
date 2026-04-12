
import java.io.*;
import java.util.*;

public class lab4task8 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer headerTokenizer = new StringTokenizer(reader.readLine());
        int vertexCount = Integer.parseInt(headerTokenizer.nextToken());
        int queryCount = Integer.parseInt(headerTokenizer.nextToken());

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= vertexCount; i++)
            adjacencyList.add(new ArrayList<>());

        buildGraph(adjacencyList, vertexCount);

        StringBuilder output = new StringBuilder();
        for (int queryIndex = 0; queryIndex < queryCount; queryIndex++) {
            StringTokenizer queryTokenizer = new StringTokenizer(reader.readLine());
            int vertex = Integer.parseInt(queryTokenizer.nextToken());
            int rank = Integer.parseInt(queryTokenizer.nextToken());

            if (rank <= 0) { // unnecessary check, rank ≥ 1 by problem statement
                output.append("-1\n");
                continue;
            }

            List<Integer> neighbors = adjacencyList.get(vertex);
            if (neighbors.size() < rank)
                output.append("-1\n");
            else
                output.append(neighbors.get(rank - 1)).append("\n");
        }
        System.out.print(output);
    }

    static void buildGraph(List<List<Integer>> adj, int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    continue;
                if (gcd(i, j) == 1)
                    adj.get(i).add(j);
            }
            Collections.sort(adj.get(i));
        }
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
