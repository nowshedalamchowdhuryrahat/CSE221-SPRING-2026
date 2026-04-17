
import java.util.Scanner;

public class lab5task6 {

    static int[] head_xxx, to_yyy, next_zzz, sub_aaa;
    static boolean[] vis_bbb;
    static int idx_ccc = 0;

    public static void main(String[] args) {
        Scanner RHT = new Scanner(System.in);
        int a1 = RHT.nextInt();
        int ar2 = RHT.nextInt();

        head_xxx = new int[a1 + 1];
        to_yyy = new int[2 * (a1 - 1) + 5];
        next_zzz = new int[2 * (a1 - 1) + 5];
        sub_aaa = new int[a1 + 1];
        vis_bbb = new boolean[a1 + 1];

        for (int i = 1; i <= a1; i++) {
            head_xxx[i] = -1;
        }

        for (int i = 0; i < a1 - 1; i++) {
            int uuu = RHT.nextInt();
            int vvv = RHT.nextInt();
            addEdge(uuu, vvv);
            addEdge(vvv, uuu);
        }

        dfs_qqq(ar2);

        int qqq = RHT.nextInt();
        for (int i = 0; i < qqq; i++) {
            int xxx = RHT.nextInt();
            System.out.print(sub_aaa[xxx] + "\n");
        }
        RHT.close();
    }

    public static void addEdge(int df, int hj) {
        to_yyy[idx_ccc] = hj;
        next_zzz[idx_ccc] = head_xxx[df];
        head_xxx[df] = idx_ccc++;
    }

    public static int dfs_qqq(int dff) {
        vis_bbb[dff] = true;
        int c = 1;
        for (int eee = head_xxx[dff]; eee != -1; eee = next_zzz[eee]) {
            int gk = to_yyy[eee];
            if (!vis_bbb[gk]) {
                c += dfs_qqq(gk);
            }
        }
        sub_aaa[dff] = c;
        return c;

    }
}
