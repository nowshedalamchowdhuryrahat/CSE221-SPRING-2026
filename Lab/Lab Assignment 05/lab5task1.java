import java.io.*;
import java.util.*;

public class lab5task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int b = Integer.parseInt(tokenizer.nextToken());
        int a1 = Integer.parseInt(tokenizer.nextToken());

        List<List<Integer>> b1 = new ArrayList<>();
        for (int i = 0; i <= b; i++) {
            b1.add(new ArrayList<>());
        }

        for (int i = 0; i < a1; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            if (x != y) {
                b1.get(x).add(y);
                b1.get(y).add(x);
            }
        }

        for (int hj = 1; hj <= b; hj++) {
            Collections.sort(b1.get(hj));
        }

        boolean[] ck = new boolean[b + 1];
        Queue<Integer> c1 = new LinkedList<>();
        List<Integer> dss = new ArrayList<>();

        ck[1] = true;
        c1.add(1);

        while (!c1.isEmpty()) {
            int e = c1.poll();
            dss.add(e);

            for (int f : b1.get(e)) {
                if (!ck[f]) {
                    if (f > 0 && f <= b) {
                        ck[f] = true;
                        c1.add(f);
                    }
                }
            }
        }

        StringBuilder output = new StringBuilder();
        int yy = dss.size();
        for (int kl = 0; kl < yy; kl++) {
            output.append(dss.get(kl));
            if (kl < yy - 1)
                output.append(' ');
        }

        System.out.print(output);
    }
}
