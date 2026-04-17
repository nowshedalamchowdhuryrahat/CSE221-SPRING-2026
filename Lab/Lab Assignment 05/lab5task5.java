
import java.io.*;
import java.util.*;

public class lab5task5 {

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int Na = Integer.parseInt(tokenizer.nextToken());
        int Ma = Integer.parseInt(tokenizer.nextToken());
        int Qa = Integer.parseInt(tokenizer.nextToken());

        parent = new int[Na + 1];
        rank = new int[Na + 1];
        for (int i = 1; i <= Na; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < Ma; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int Ua = Integer.parseInt(tokenizer.nextToken());
            int Va = Integer.parseInt(tokenizer.nextToken());
            union(Ua, Va);
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < Qa; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int Xa = Integer.parseInt(tokenizer.nextToken());
            int Ya = Integer.parseInt(tokenizer.nextToken());
            output.append(find(Xa) == find(Ya) ? "YES" : "NO").append('\n');
        }

        System.out.print(output);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        }
        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootB] < rank[rootA]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }
}
