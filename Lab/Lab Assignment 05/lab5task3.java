import java.util.*;
import java.io.*;
public class lab5task3 {
    public static void main(String[] args) throws Exception {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer strr = new StringTokenizer(RHT.readLine());
        int nA = Integer.parseInt(strr.nextToken());
        int mA = Integer.parseInt(strr.nextToken());
        int sA = Integer.parseInt(strr.nextToken());
        int dA = Integer.parseInt(strr.nextToken());
        List<List<Integer>> a1 = new ArrayList<>();
        int ini = 0;
        while (ini <= nA) {
            a1.add(new ArrayList<>());
            ini++;
        }
        int[] x = new int[mA];
        int[] y = new int[mA];
        if (mA > 0) {
            strr = new StringTokenizer(RHT.readLine());
            ini = 0;
            while (ini < mA) {
                x[ini] = Integer.parseInt(strr.nextToken());
                ini++;
            }
            strr = new StringTokenizer(RHT.readLine());
            ini = 0;
            while (ini < mA) {
                y[ini] = Integer.parseInt(strr.nextToken());
                ini++;
            }
        }
        ini = 0;
        while (ini < mA) {
            if (x[ini] != y[ini]) {
                a1.get(x[ini]).add(y[ini]);
                a1.get(y[ini]).add(x[ini]);
            }
            ini++;
        }
        ini = 1;
        while (ini <= nA) {
            Collections.sort(a1.get(ini));
            ini++;
        }
        int[] dist = new int[nA + 1];
        Arrays.fill(dist, -1);
        int[] par = new int[nA + 1];
        Arrays.fill(par, -1);
        Deque<Integer> q1 = new ArrayDeque<>();
        dist[sA] = 0;
        q1.add(sA);
        while (!q1.isEmpty()) {
            int cur = q1.poll();
            int j = 0;
            while (j < a1.get(cur).size()) {
                int nxt = a1.get(cur).get(j);
                if (dist[nxt] == -1) {
                    dist[nxt] = dist[cur] + 1;
                    par[nxt] = cur;
                    q1.add(nxt);
                }
                j++;
            }
        }

        if (dist[dA] == -1) {
            System.out.println(-1);
            return;
        }

        System.out.println(dist[dA]);

        List<Integer> path = new ArrayList<>();
        int now = dA;

        while (now != -1) {
            path.add(now);
            now = par[now];
        }

        Collections.reverse(path);

        StringBuilder sb = new StringBuilder();
        ini = 0;
        while (ini < path.size()) {
            sb.append(path.get(ini));
            if (ini < path.size() - 1)
                sb.append(" ");
            ini++;
        }

        System.out.println(sb.toString());
    }
}
