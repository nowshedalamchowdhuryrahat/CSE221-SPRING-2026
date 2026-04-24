import java.io.*;
import java.util.*;

public class lab6task4 {
    static ArrayList<ArrayList<Integer>> adj;

    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(RHT.readLine());

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(RHT.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int node1 = bfs(1, n)[0];
        int[] result = bfs(node1, n);
        int node2 = result[0];
        int diameter = result[1];

        System.out.println(diameter);
        System.out.println(node1 + " " + node2);
    }

    static int[] bfs(int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        distance[start] = 0;
        queue.add(start);

        int farthest = start;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : adj.get(node)) {
                if (distance[next] == -1) {
                    distance[next] = distance[node] + 1;
                    queue.add(next);
                    if (distance[next] > distance[farthest]) {
                        farthest = next;
                    }
                }
            }
        }
        return new int[] { farthest, distance[farthest] };
    }
}
