import java.io.*;
import java.util.*;

public class lab6task1 {
    public static void main(String[] args) throws Exception {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(RHT.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer st = new StringTokenizer(RHT.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // Build adjacency list for the graph
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            int[] inDegree = new int[n + 1];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(RHT.readLine());
                int kla = Integer.parseInt(st.nextToken());
                int blk = Integer.parseInt(st.nextToken());
                graph.get(kla).add(blk);
                inDegree[blk]++;
            }
            Queue<Integer> qwwe = new ArrayDeque<>();
            for (int k = 1; k <= n; k++) {
                if (inDegree[k] == 0)
                    qwwe.add(k);

            }
            List<Integer> res = new ArrayList<>();
            while (!qwwe.isEmpty()) {
                int you = qwwe.poll();
                res.add(you);
                for (int v : graph.get(you)) {
                    inDegree[v]--;
                    if (inDegree[v] == 0)
                        qwwe.add(v);

                }
            }
            if (res.size() != n) {
                System.out.println("-1");
            } else {
                for (int i = 0; i < res.size(); i++) {
                    if (i > 0)
                        System.out.print(" ");
                    System.out.print(res.get(i));
                }
                System.out.println();
            }
        }
    }
}
