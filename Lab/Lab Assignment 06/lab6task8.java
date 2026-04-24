import java.io.*;
import java.util.*;

public class lab6task8 {
    public static void main(String[] args) throws Exception {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(RHT.readLine().trim());
        String[] wrd = new String[N];

        for (int i = 0; i < N; i++) 
            wrd[i] = RHT.readLine().trim();
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) graph.add(new ArrayList<>());

        int[] indeg = new int[26];
        boolean[] used = new boolean[26];

        for (String w : wrd) {
            for (char c : w.toCharArray()) {
                used[c - 'a'] = true;
            }
        }

        boolean[][] hasEdge = new boolean[26][26];

        for (int i = 0; i < N - 1; i++) {
            String w1 = wrd[i], w2 = wrd[i+1];
            int l = Math.min(w1.length(), w2.length());
            boolean found = false;

            for (int j = 0; j < l; j++) {
                char a = w1.charAt(j), b = w2.charAt(j);
                if (a != b) {
                    int u = a - 'a', v = b - 'a';
                    if (!hasEdge[u][v]) {
                        graph.get(u).add(v);
                        indeg[v]++;
                        hasEdge[u][v] = true;
                    }
                    found = true;
                    break;
                }
            }           if (!found && w1.length() > w2.length()) {
                System.out.println("-1");
                return;
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 26; i++) {
            if (used[i] && indeg[i] == 0) pq.add(i);
        }

        StringBuilder ans = new StringBuilder();

        while (!pq.isEmpty()) {
            int u = pq.poll();
            ans.append((char)(u + 'a'));

            for (int v : graph.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) pq.add(v);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (used[i] && indeg[i] != 0) {
                System.out.println("-1");
                return;
            }
        }

        System.out.println(ans.toString());
    }
}
