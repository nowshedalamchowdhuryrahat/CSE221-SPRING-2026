
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class lab7task1 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer = new StringTokenizer("");

    static String nextToken() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(nextToken());
        int M = Integer.parseInt(nextToken());
        int S = Integer.parseInt(nextToken());
        int D = Integer.parseInt(nextToken());
        int[] u = new int[M];
        int[] v = new int[M];
        int[] w = new int[M];

        for (int i = 0; i < M; i++)
            u[i] = Integer.parseInt(nextToken());
        for (int i = 0; i < M; i++)
            v[i] = Integer.parseInt(nextToken());
        for (int i = 0; i < M; i++)
            w[i] = Integer.parseInt(nextToken());

        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            graph[u[i]].add(new Edge(v[i], w[i]));
        }

        long[] dist = new long[N + 1];
        int[] parent = new int[N + 1];
        long INF = Long.MAX_VALUE / 4;

        for (int i = 1; i <= N; i++) {
            dist[i] = INF;
            parent[i] = -1;
        }
        dist[S] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[] { 0, S });

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long d = current[0];
            int node = (int) current[1];

            if (d != dist[node]) {
                continue;
            }
            if (node == D) {
                break;
            }

            for (Edge edge : graph[node]) {
                int to = edge.to;
                long cost = edge.weight;
                if (d + cost < dist[to]) {
                    dist[to] = d + cost;
                    parent[to] = node;
                    pq.add(new long[] { dist[to], to });
                }
            }
        }

        if (dist[D] == INF) {
            System.out.println(-1);
            reader.close();
            return;
        }

        System.out.println(dist[D]);

        int[] path = new int[N + 1];
        int length = 0;
        int current = D;
        while (current != -1) {
            path[length] = current;
            length++;
            current = parent[current];
        }
        for (int i = length - 1; i >= 0; i--) {
            System.out.print(path[i]);
            if (i > 0)
                System.out.print(" ");

        }
        System.out.println();
        reader.close();
    }
}
