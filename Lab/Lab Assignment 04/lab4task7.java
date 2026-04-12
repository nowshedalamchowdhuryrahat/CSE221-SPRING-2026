
import java.io.*;
import java.util.*;

public class lab4task7 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int rowCount = Integer.parseInt(tokenizer.nextToken());
        int columnCount = Integer.parseInt(tokenizer.nextToken());
        int knightCount = Integer.parseInt(tokenizer.nextToken());

        boolean[][] hasKnight = new boolean[rowCount + 1][columnCount + 1];
        int[][] knightPositions = new int[knightCount][2];

        for (int i = 0; i < knightCount; i++) {
            StringTokenizer positionTokenizer = new StringTokenizer(reader.readLine());
            int row = Integer.parseInt(positionTokenizer.nextToken());
            int col = Integer.parseInt(positionTokenizer.nextToken());
            knightPositions[i][0] = row;
            knightPositions[i][1] = col;
            if (row >= 1 && row <= rowCount && col >= 1 && col <= columnCount) {
                hasKnight[row][col] = true;
            }
        }

        System.out.println(canAttack(hasKnight, knightPositions, rowCount, columnCount) ? "YES" : "NO");
    }

    static boolean canAttack(boolean[][] hasKnight, int[][] knightPositions, int rowCount, int columnCount) {
        int[] rowDelta = { -2, -2, -1, -1, 1, 1, 2, 2 };
        int[] colDelta = { -1, 1, -2, 2, -2, 2, -1, 1 };

        for (int i = 0; i < knightPositions.length; i++) {
            int row = knightPositions[i][0];
            int col = knightPositions[i][1];
            for (int j = 0; j < 8; j++) {
                int nextRow = row + rowDelta[j];
                int nextCol = col + colDelta[j];
                if (nextRow < 1 || nextRow > rowCount || nextCol < 1 || nextCol > columnCount)
                    continue;
                if (hasKnight[nextRow][nextCol])
                    return true;
            }
        }
        return false;
    }
}