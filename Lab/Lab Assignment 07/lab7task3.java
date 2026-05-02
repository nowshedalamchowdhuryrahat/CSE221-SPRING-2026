import java.io.*;
import java.util.*;

public class lab7task3 {

    static class Edge {
        int to;
        int weight;

        Edge(int t, int w) {
            to = t;
            weight = w;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            graph[from].add(new Edge(to, weight));
            graph[to].add(new Edge(from, weight));
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        dist[1] = 0;
        pq.add(new long[] { 0, 1 });

        while (!pq.isEmpty()) {

            long[] current = pq.poll();
            long distance = current[0];
            int node = (int) current[1];

            if (distance > dist[node])
                continue;

            for (Edge edge : graph[node]) {
                long newDist = Math.max(distance, edge.weight);

                if (newDist < dist[edge.to]) {
                    dist[edge.to] = newDist;
                    pq.add(new long[] { newDist, edge.to });
                }
            }
        }

        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == Long.MAX_VALUE)
                output.append("-1 ");
            else
                output.append(dist[i]).append(" ");
        }

        System.out.println(output.toString().trim());
    }
}
