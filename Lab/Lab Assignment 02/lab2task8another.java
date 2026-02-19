import java.util.*;

public class lab2task8another {
    public static void main(String[] args) {
        Scanner RHT = new Scanner(System.in);
        int test = RHT.nextInt();
     for (int g = 0; g < test; g++) {
            long a = RHT.nextLong();
            long ab = RHT.nextLong();
            long resulT = a + (a - 1) / (ab - 1);
            System.out.println(resulT);

        }
        RHT.close();

    }
}
