import java.io.*;
import java.util.*;

public class lab6task5 {
    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(RHT.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int numDestinations = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(RHT.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        st = new StringTokenizer(RHT.readLine());
        int[] sources = new int[k];
        for (int i = 0; i < k; i++)
            sources[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(RHT.readLine());
        int[] destinations = new int[numDestinations];
        for (int i = 0; i < numDestinations; i++)
            destinations[i] = Integer.parseInt(st.nextToken());
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();
        for (int s : sources) {
            distance[s] = 0;
            queue.add(s);
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : adj.get(node)) {
                if (distance[next] == -1) {
                    distance[next] = distance[node] + 1;
                    queue.add(next);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int d : destinations)
            result.append(distance[d]).append(' ');
        System.out.println(result.toString());
    }
}
