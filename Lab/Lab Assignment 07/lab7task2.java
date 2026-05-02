import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class lab7task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int S = Integer.parseInt(tokenizer.nextToken());
        int D = Integer.parseInt(tokenizer.nextToken());
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        long[] distFromSource = new long[N + 1];
        long[] distFromDest = new long[N + 1];
        for (int i = 0; i <= N; i++) {
            distFromSource[i] = Long.MAX_VALUE;
            distFromDest[i] = Long.MAX_VALUE;
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());
            graph.get(from).add(new Edge(to, weight));
        }
        dijkstraAlgo(distFromSource, S, graph);
        dijkstraAlgo(distFromDest, D, graph);
        long min = Long.MAX_VALUE;
        int bestNode = -1;
        for (int i = 1; i <= N; i++) {
            long mx = Math.max(distFromSource[i], distFromDest[i]);
            if (mx < min) {
                min = mx;
                bestNode = i;
            }
        }
        if (bestNode != -1) {
            System.out.println(min + " " + bestNode);
        } 
        else {
            System.out.println(-1);
        }
    }
    static void dijkstraAlgo(long[] dist, int start, ArrayList<ArrayList<Edge>> graph) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        dist[start] = 0;
        pq.add(new long[] { 0, start });
        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long d = current[0];
            int node = (int) current[1];
            if (d > dist[node])
                continue;
            for (Edge edge : graph.get(node)) {
                if (d + edge.weight < dist[edge.to]) {
                    dist[edge.to] = d + edge.weight;
                    pq.add(new long[] { dist[edge.to], edge.to });
                }
            }
        }
    }
}
class Edge {
    int to;
    int weight;
    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}
