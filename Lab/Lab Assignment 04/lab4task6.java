
import java.io.*;
import java.util.*;

public class lab4task6 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int boardSize = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int startRow = Integer.parseInt(tokenizer.nextToken());
        int startCol = Integer.parseInt(tokenizer.nextToken());

        List<int[]> validMoves = new ArrayList<>();
        findMoves(boardSize, startRow, startCol, validMoves);

        Collections.sort(validMoves,
                (first, second) -> first[0] == second[0] ? first[1] - second[1] : first[0] - second[0]);

        System.out.println(validMoves.size());
        for (int[] move : validMoves) {
            System.out.println(move[0] + " " + move[1]);
        }
    }

    static void findMoves(int boardSize, int row, int col, List<int[]> moves) {
        int[] rowDelta = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] colDelta = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int i = 0; i < 8; i++) {
            int nextRow = row + rowDelta[i];
            int nextCol = col + colDelta[i];

            if (nextRow < 1 || nextRow > boardSize || nextCol < 1 || nextCol > boardSize)
                continue;
            moves.add(new int[] { nextRow, nextCol });
        }
    }
}
