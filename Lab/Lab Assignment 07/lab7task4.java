import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class lab7task4 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int S = Integer.parseInt(tokenizer.nextToken());
        int D = Integer.parseInt(tokenizer.nextToken());

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        int[] dist = new int[N + 1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        tokenizer = new StringTokenizer(reader.readLine());
        int[] nodeWeights = new int[N + 1];
        for (int i = 1; i < nodeWeights.length; i++) {
            nodeWeights[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] fromNodes = new int[M];
        int[] toNodes = new int[M];

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            fromNodes[i] = Integer.parseInt(tokenizer.nextToken());
            toNodes[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 0; i < M; i++) {
            graph.get(fromNodes[i]).add(new Edge(toNodes[i], nodeWeights[toNodes[i]]));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        dist[S] = nodeWeights[S];
        pq.add(new Edge(S, nodeWeights[S]));

        while (!pq.isEmpty()) {

            Edge current = pq.poll();
            int node = current.to;
            int cost = current.weight;

            for (Edge edge : graph.get(node)) {
                int newCost = cost + edge.weight;

                if (newCost < dist[edge.to]) {
                    dist[edge.to] = newCost;
                    pq.add(new Edge(edge.to, dist[edge.to]));
                }
            }
        }

        if (dist[D] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist[D]);
        }
    }
}

class Edge implements Comparable<Edge> {

    int to;
    int weight;

    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}
