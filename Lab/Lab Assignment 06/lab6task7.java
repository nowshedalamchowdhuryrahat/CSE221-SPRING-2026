import java.io.*;
import java.util.*;

public class lab6task7 {
    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(RHT.readLine());

        int input = Integer.parseInt(st.nextToken());
        String stR = st.nextToken();
        String fixedW = st.nextToken();

        ArrayList<String> wrdss = new ArrayList<>();
        for (int i = 0; i < input; i++) {
            wrdss.add(RHT.readLine().trim());
        }
        HashMap<Character, ArrayList<Integer>> wordsByFirstChar = new HashMap<>();
        int stInd = -1, targetIndex = -1;

        for (int i = 0; i < input; i++) {
            char firstChar = wrdss.get(i).charAt(0);
            wordsByFirstChar.computeIfAbsent(firstChar, k -> new ArrayList<>()).add(i);

            if (wrdss.get(i).equals(stR))
                stInd = i;
            if (wrdss.get(i).equals(fixedW))
                targetIndex = i;
        }
        if (stInd == -1 || targetIndex == -1) {
            System.out.println("NO");
            return;
        }
        if (stInd == targetIndex) {
            System.out.println("YES");
            return;
        }

        boolean klo = bfs(wrdss, wordsByFirstChar, stInd, targetIndex);
        System.out.println(klo ? "YES" : "NO");
    }

    static boolean bfs(ArrayList<String> wrdss, HashMap<Character, ArrayList<Integer>> wordsByFirstChar, int st,
            int target) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[wrdss.size()];
        boolean[] letterUsed = new boolean[26];

        queue.add(st);
        visited[st] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == target)
                return true;

            char lastChar = wrdss.get(current).charAt(wrdss.get(current).length() - 1);
            int letterIndex = lastChar - 'A';
            if (letterUsed[letterIndex]) {
                continue;
            }
            letterUsed[letterIndex] = true;

            ArrayList<Integer> nextWords = wordsByFirstChar.getOrDefault(lastChar, new ArrayList<>());
            for (int next : nextWords) {
                if (!visited[next]) {
                    visited[next] = true;
                    if (next == target)
                        return true;
                    queue.add(next);
                }
            }
        }
        return false;
    }
}
