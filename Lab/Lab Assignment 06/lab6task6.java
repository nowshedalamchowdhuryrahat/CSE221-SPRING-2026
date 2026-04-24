import java.io.*;
import java.util.*;

public class lab6task6 {
    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(RHT.readLine());
        String strT = st.nextToken();
        String fixed = st.nextToken();

        int input = Integer.parseInt(RHT.readLine());
        HashSet<String> forbid = new HashSet<>();
        for (int i = 0; i < input; i++) {
            forbid.add(RHT.readLine().trim());
        }

        int res = bfs(strT, fixed, forbid);
        System.out.println(res);
    }

    static int bfs(String start, String target, HashSet<String> forbidden) {
        if (start.equals(target))
            return 0;

        Set<String> v = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distance = new HashMap<>();

        queue.add(start);
        v.add(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int curD = distance.get(cur);

            for (int i = 0; i < 4; i++) {
                String nextInc = incrementDigit(cur, i);
                if (!forbidden.contains(nextInc) && !v.contains(nextInc)) {
                    if (nextInc.equals(target))
                        return curD + 1;
                    v.add(nextInc);
                    distance.put(nextInc, curD + 1);
                    queue.add(nextInc);
                }
                String nextDec = decrementDigit(cur, i);
                if (!forbidden.contains(nextDec) && !v.contains(nextDec)) {
                    if (nextDec.equals(target))
                        return curD + 1;
                    v.add(nextDec);
                    distance.put(nextDec, curD + 1);
                    queue.add(nextDec);
                }
            }
        }
        return -1;
    }

    static String incrementDigit(String spo, int pos) {
        char[] a = spo.toCharArray();
        int dig = a[pos] - '0';
        dig = (dig + 1) % 10;
        a[pos] = (char) ('0' + dig);
        return new String(a);
    }

    static String decrementDigit(String s, int pos) {
        char[] ar = s.toCharArray();
        int dig = ar[pos] - '0';
        dig = (dig - 1 + 10) % 10;
        ar[pos] = (char) ('0' + dig);
        return new String(ar);
    }
}
