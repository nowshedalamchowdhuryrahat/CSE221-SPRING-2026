import java.util.*;
import java.io.*;

public class lab5task4 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");

        int Na = Integer.parseInt(tokens[0]);
        int Ma = Integer.parseInt(tokens[1]);
        int Sa = Integer.parseInt(tokens[2]);
        int Da = Integer.parseInt(tokens[3]);
        int Ka = Integer.parseInt(tokens[4]);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= Na; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < Ma; i++) {
            tokens = reader.readLine().split(" ");
            int Xa = Integer.parseInt(tokens[0]);
            int Ya = Integer.parseInt(tokens[1]);
            graph.get(Xa).add(Ya);
        }

        int[] disStart = new int[Na + 1];
        int[] disKey = new int[Na + 1];

        Arrays.fill(disStart, -1);
        Arrays.fill(disKey, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(Sa);
        disStart[Sa] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph.get(u)) {
                if (disStart[v] == -1 || disStart[v] > disStart[u] + 1) {
                    disStart[v] = disStart[u] + 1;
                    queue.add(v);
                }
            }
        }

        queue = new LinkedList<>();
        queue.add(Ka);
        disKey[Ka] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph.get(u)) {
                if (disKey[v] == -1 || disKey[v] > disKey[u] + 1) {
                    disKey[v] = disKey[u] + 1;
                    queue.add(v);
                }
            }
        }

        if (disStart[Ka] == -1 || disKey[Da] == -1 || (Sa == Da && Ka != Sa)) {
            System.out.println(-1);
            return;
        }

        if (Sa == Da && Ka == Sa) {
            System.out.println(0);
            System.out.println(Sa);
            return;
        }

        int totalAR = disStart[Ka] + disKey[Da];
        System.out.println(totalAR);

        int[] parentFromStart = new int[Na + 1];
        Arrays.fill(parentFromStart, -1);

        queue = new LinkedList<>();
        queue.add(Sa);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph.get(u)) {
                if (parentFromStart[v] == -1 && disStart[v] == disStart[u] + 1) {
                    parentFromStart[v] = u;
                    queue.add(v);
                }
            }
        }

        int[] par = new int[Na + 1];
        Arrays.fill(par, -1);

        queue = new LinkedList<>();
        queue.add(Ka);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph.get(u)) {
                if (par[v] == -1 && disKey[v] == disKey[u] + 1) {
                    par[v] = u;
                    queue.add(v);
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        int cur = Da;

        while (cur != Ka) {
            path.add(cur);
            cur = par[cur];
            if (cur == -1)
                break;
        }

        path.add(Ka);
        Collections.reverse(path);

        cur = Ka;
        while (cur != Sa) {
            cur = parentFromStart[cur];
            if (cur == -1)
                break;
            path.add(0, cur);
        }

        StringBuilder sb = new StringBuilder();
        for (int node : path) {
            sb.append(node).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
