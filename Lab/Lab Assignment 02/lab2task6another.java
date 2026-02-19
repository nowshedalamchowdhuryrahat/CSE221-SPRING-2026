import java.util.*;

public class lab2task6another {
    public static void main(String[] args) {
        Scanner RHT = new Scanner(System.in);

        int sz = RHT.nextInt();
        int Distelement = RHT.nextInt();

        int[] ar1 = new int[sz];
        for (int m = 0; m < sz; m++)
            ar1[m] = RHT.nextInt();

        HashMap<Integer, Integer> Cnt = new HashMap<>();
        int lft = 0;
        int mxx = 0;

        for (int M = 0; M < sz; M++) {
            Integer kn = Cnt.get(ar1[M]);
            if (kn == null) {
                Cnt.put(ar1[M], 1);
            } else {
                Cnt.put(ar1[M], kn + 1);
            }

            while (Cnt.size() > Distelement) {
                Cnt.put(ar1[lft], Cnt.get(ar1[lft]) - 1);
                if (Cnt.get(ar1[lft]) == 0) {
                    Cnt.remove(ar1[lft]);
                }
                lft++;
            }

            mxx = Math.max(mxx, M - lft + 1);
        }
        RHT.close();
        System.out.println(mxx);
    }
}
