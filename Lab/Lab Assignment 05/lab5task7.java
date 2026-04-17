import java.util.Arrays;
import java.util.Scanner;

public class lab5task7 {

    static int[] head, to_qwe, next_qwe;
    static int ed_cnt = 0;
    static int[] clr;
    static boolean cyc = false;
    static int n;

    public static void addEdge(int u, int v) {
        to_qwe[ed_cnt] = v;
        next_qwe[ed_cnt] = head[u];
        head[u] = ed_cnt++;
    }

    public static void dfs(int u) {
        clr[u] = 1;
        for (int e = head[u]; e != -1; e = next_qwe[e]) {
            int gh = to_qwe[e];
            if (clr[gh] == 0) {
                dfs(gh);
                if (cyc) {
                    return;
                }
            } else if (clr[gh] == 1) {
                cyc = true;
                return;
            }
        }
        clr[u] = 2;
    }

    public static void main(String[] args) {
        Scanner RHT = new Scanner(System.in);
        n = RHT.nextInt();
        int m = RHT.nextInt();

        head = new int[n + 1];
        Arrays.fill(head, -1);
        to_qwe = new int[m];
        next_qwe = new int[m];

        for (int i = 0; i < m; i++) {
            int u = RHT.nextInt();
            int v = RHT.nextInt();
            addEdge(u, v);
        }
        RHT.close();
        clr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (clr[i] == 0) {
                dfs(i);
                if (cyc) {
                    break;
                }
            }
        }

        if (cyc) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
