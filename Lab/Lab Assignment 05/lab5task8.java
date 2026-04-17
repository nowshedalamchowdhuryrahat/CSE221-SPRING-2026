import java.util.*;
import java.io.*;

public class lab5task8 {
    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        String[] s = RHT.readLine().split(" ");
        int a1 = Integer.parseInt(s[0]);
        int a2 = Integer.parseInt(s[1]);

        char[][] gr = new char[a1][a2];
        for (int x1 = 0; x1 < a1; x1++) {
            gr[x1] = RHT.readLine().toCharArray();
        }

        boolean[][] vs = new boolean[a1][a2];
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        int mx = 0;

        for (int x1 = 0; x1 < a1; x1++) {
            for (int x2 = 0; x2 < a2; x2++) {

                if (gr[x1][x2] != '#' && !vs[x1][x2]) {

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] { x1, x2 });
                    vs[x1][x2] = true;

                    int ct = 0;

                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        int y1 = p[0];
                        int y2 = p[1];

                        if (gr[y1][y2] == 'D')
                            ct++;

                        for (int k = 0; k < 4; k++) {
                            int n1 = y1 + dr[k];
                            int n2 = y2 + dc[k];

                            if (n1 >= 0 && n1 < a1 && n2 >= 0 && n2 < a2) {
                                if (!vs[n1][n2] && gr[n1][n2] != '#') {
                                    vs[n1][n2] = true;
                                    q.add(new int[] { n1, n2 });
                                }
                            }
                        }
                    }

                    if (ct > mx)
                        mx = ct;
                }
            }
        }

        System.out.println(mx);
    }
}
