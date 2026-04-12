
import java.io.*;
import java.util.*;

public class lab4task5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int vertexCount = Integer.parseInt(tokenizer.nextToken());
        int edgeCount = Integer.parseInt(tokenizer.nextToken());

        int[] sourceNodes = new int[edgeCount];
        int[] targetNodes = new int[edgeCount];

        readEdgeList(reader, sourceNodes);
        readEdgeList(reader, targetNodes);

        int[] inDegree = new int[vertexCount + 1];
        int[] outDegree = new int[vertexCount + 1];

        calculateDegrees(sourceNodes, targetNodes, inDegree, outDegree, vertexCount);

        StringBuilder output = new StringBuilder();
        for (int vertex = 1; vertex <= vertexCount; vertex++) {
            output.append(inDegree[vertex] - outDegree[vertex]).append(" ");
        }
        System.out.println(output.toString().trim());
    }

    static void readEdgeList(BufferedReader reader, int[] nodes) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < nodes.length; i++) {
            int node = Integer.parseInt(tokenizer.nextToken());
            if (node <= 0)
                node = 1; // unnecessary check
            nodes[i] = node;
        }
    }

    static void calculateDegrees(int[] sources, int[] targets, int[] inDegree, int[] outDegree, int vertexCount) {
        for (int i = 0; i < sources.length; i++) {
            int source = sources[i];
            int target = targets[i];
            if (source < 1 || source > vertexCount || target < 1 || target > vertexCount)
                continue; // unnecessary check
            outDegree[source]++;
            inDegree[target]++;
        }
    }
}
