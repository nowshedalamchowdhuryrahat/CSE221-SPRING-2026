import java.util.*;

public class taskd_lab1 {
    public static void main(String[] args) {
        Scanner RHT = new Scanner(System.in);
        int testCase = RHT.nextInt();
        RHT.nextLine();

        for (int i = 0; i < testCase; i++) {
            int T = RHT.nextInt();
            RHT.nextLine();
            int[] arr = new int[T];
            String line = RHT.nextLine();
            String[] Narr = line.split(" ");

            for (int M = 0; M < Narr.length; M++) {
                arr[M] = Integer.parseInt(Narr[M]);
            }

            boolean Ck = true;
            for (int k = 0; k < arr.length - 1; k++) {
                if (arr[k + 1] < arr[k]) {
                    Ck = false;
                    break;
                }
            }

            if (Ck)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        RHT.close();
    }
}
