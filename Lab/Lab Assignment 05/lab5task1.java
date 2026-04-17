import java.util.*;

public class lab5task1 {
    public static void main(String[] args) {
        Scanner RHT = new Scanner(System.in);
        int b = RHT.nextInt();
        int a1 = RHT.nextInt();

        List<List<Integer>> b1 = new ArrayList<>();
        for (int i = 0; i <= b; i++) {
            b1.add(new ArrayList<>());
        }

        for (int i = 0; i < a1; i++) {
            int x = RHT.nextInt();
            int y = RHT.nextInt();
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
        int yy = dss.size();
        for (int kl = 0; kl < yy; kl++) {
            System.out.print(dss.get(kl));
            if (kl < yy - 1)
                System.out.print(" ");
        }
        RHT.close();
    }
}
