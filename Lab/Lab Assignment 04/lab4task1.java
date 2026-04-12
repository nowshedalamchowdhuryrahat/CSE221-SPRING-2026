import java.util.*;
import java.io.*;

public class lab4task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int matrixSize = Integer.parseInt(tokenizer.nextToken());
        int edgeCount = Integer.parseInt(tokenizer.nextToken());

        if (matrixSize <= 0) {
            writer.println("0");
            writer.flush();
            reader.close();
            writer.close();
            return;
        }

        int[][] adjacencyMatrix = new int[matrixSize][matrixSize];

        for (int edgeIndex = 0; edgeIndex < edgeCount; edgeIndex++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int source = Integer.parseInt(tokenizer.nextToken());
            int destination = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            if (source < 1 || source > matrixSize || destination < 1 || destination > matrixSize) {
                continue;
            }

            if (weight < 0) {
                weight = 0;
            }

            adjacencyMatrix[source - 1][destination - 1] = weight;
        }

        StringBuilder output = new StringBuilder();
        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                output.append(adjacencyMatrix[row][col]).append(" ");
            }
            output.append("\n");
        }
        writer.print(output);
        writer.flush();
        reader.close();
        writer.close();
    }
}
