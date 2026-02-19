import java.util.*;

public class taskg_lab1 {
    public static void main(String[] args) {
        Scanner RHT = new Scanner(System.in);
        int T = RHT.nextInt(); 
        for (int t = 0; t < T; t++) {
            int N = RHT.nextInt();

            int[] stuid = new int[N];
            int[] stu_mark = new int[N];

            for (int i = 0; i < N; i++)  stuid[i] = RHT.nextInt();

            for (int i = 0; i < N; i++)  stu_mark[i] = RHT.nextInt();

  int c = 0;
            for (int i = 0; i < N - 1; i++) {
                int MX = i;
                for (int K = i + 1; K < N; K++) {
                    if (stu_mark[K] > stu_mark[MX] ||
                        (stu_mark[K] == stu_mark[MX] && stuid[K] < stuid[MX])) {
                        MX = K;
                    }
                }

                if (MX != i) {
                    int tempM = stu_mark[i];
                    stu_mark[i] = stu_mark[MX];
                    stu_mark[MX] = tempM;

                    int tempID = stuid[i];
                    stuid[i] = stuid[MX];
                    stuid[MX] = tempID;

                    c++;
                }
            }
            System.out.println("Minimum swaps: " + c);
            for (int i = 0; i < N; i++) {
                System.out.println("ID: " + stuid[i] + " Mark: " + stu_mark[i]);
            }
        }

        RHT.close();
    }
}
