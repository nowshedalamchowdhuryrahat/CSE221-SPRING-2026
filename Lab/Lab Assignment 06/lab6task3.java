import java.io.*;
import java.util.*;

public class lab6task3 {
    static final int[] rowMoves = { 2, 2, -2, -2, 1, 1, -1, -1 };
    static final int[] colMoves = { 1, -1, 1, -1, 2, -2, 2, -2 };

    public static void main(String[] args) throws Exception {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(RHT.readLine());
        StringTokenizer st = new StringTokenizer(RHT.readLine());
        int startRow = Integer.parseInt(st.nextToken()) - 1;
        int startCol = Integer.parseInt(st.nextToken()) - 1;
        int endRow = Integer.parseInt(st.nextToken()) - 1;
        int endCol = Integer.parseInt(st.nextToken()) - 1;

        int ans = bfsKnight(n, startRow, startCol, endRow, endCol);
        System.out.println(ans);
    }

    static int bfsKnight(int n, int startRow, int startCol, int endRow, int endCol) {
        if (startRow == endRow && startCol == endCol)
            return 0;

        int[][] distance = new int[n][n];
        for (int[] row : distance)
            Arrays.fill(row, -1);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { startRow, startCol });
        distance[startRow][startCol] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            for (int k = 0; k < 8; k++) {
                int newRow = x + rowMoves[k];
                int newCol = y + colMoves[k];

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && distance[newRow][newCol] == -1) {
                    distance[newRow][newCol] = distance[x][y] + 1;

                    if (newRow == endRow && newCol == endCol)
                        return distance[newRow][newCol];

                    queue.add(new int[] { newRow, newCol });
                }
            }
        }

        return -1;
    }
}
