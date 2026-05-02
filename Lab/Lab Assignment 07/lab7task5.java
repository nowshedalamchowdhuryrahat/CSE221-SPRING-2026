import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class lab7task5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int S = 1;
        int D = N;
        ArrayList<ArrayList<tuple>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());
        tokenizer = new StringTokenizer(reader.readLine());
        int[] fromNodes = new int[M];
        for (int i = 0; i < M; i++)
            fromNodes[i] = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        int[] toNodes = new int[M];
        for (int i = 0; i < M; i++)
            toNodes[i] = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int[] weights = new int[M];
        for (int i = 0; i < M; i++)
            weights[i] = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < M; i++) {
            graph.get(fromNodes[i]).add(
                    new tuple(toNodes[i], weights[i], weights[i] % 2));
        }
        int INF = Integer.MAX_VALUE;
        int[][] dist = new int[N + 1][2];
        for (int i = 0; i <= N; i++) {
            dist[i][0] = INF;
            dist[i][1] = INF;
        }
        PriorityQueue<tuple> pq = new PriorityQueue<>();
        for (tuple edge : graph.get(S)) {
            int parity = edge.parity;
            dist[edge.value][parity] = edge.weight;
            pq.add(new tuple(edge.value, edge.weight, parity));
        }
        while (!pq.isEmpty()) {
            tuple current = pq.poll();
            int node = current.value;
            int cost = current.weight;
            int parity = current.parity;

            if (cost > dist[node][parity])
                continue;

            for (tuple edge : graph.get(node)) {
                int newParity = edge.parity;
                if (newParity == parity)
                    continue;

                if (cost + edge.weight < dist[edge.value][newParity]) {
                    dist[edge.value][newParity] = cost + edge.weight;
                    pq.add(
                            new tuple(edge.value, dist[edge.value][newParity], newParity));
                }
            }
        }

        int answer = Math.min(dist[D][0], dist[D][1]);
        System.out.println(answer == INF ? -1 : answer);
    }
}

class tuple implements Comparable<tuple> {
    int value;
    int weight;
    int parity;

    tuple(int value, int weight, int parity) {
        this.value = value;
        this.weight = weight;
        this.parity = parity;
    }

    public int compareTo(tuple other) {
        return this.weight - other.weight;
    }
}
