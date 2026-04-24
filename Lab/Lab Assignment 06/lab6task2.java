import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class lab6task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer strr = new StringTokenizer(RHT.readLine());
        int N = Integer.parseInt(strr.nextToken());
        int M = Integer.parseInt(strr.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++)  graph.add(new ArrayList<>());
         for (int i = 0; i < M; i++) {
            strr = new StringTokenizer(RHT.readLine());
            int kshto = Integer.parseInt(strr.nextToken());
            int me = Integer.parseInt(strr.nextToken());
            graph.get(kshto).add(me);
            graph.get(me).add(kshto);
        }

        int[] rong = new int[N + 1];
        Arrays.fill(rong, -1);

        int uttor = 0;

        for (int i = 1; i <= N; i++) {
            if (rong[i] == -1)     uttor += komponent(i, graph, rong);
             }
        System.out.println(uttor);
    }

    public static int komponent (int hehe, ArrayList<ArrayList<Integer>> graph, int[] color) {
        Queue<Integer> qwe = new LinkedList<>();
        qwe.add(hehe);

        color[hehe] = 0;  

        int c0 = 1, c1 = 0;

        while (!qwe.isEmpty()) {
            int node = qwe.poll();

            for (int next : graph.get(node)) {
                if (color[next] == -1) {
                    color[next] = 1 - color[node];
                    if (color[next] == 0) c0++;
                    else c1++;
                    qwe.add(next);
                }
            }
        }

        return Math.max(c0, c1);
    }
}
