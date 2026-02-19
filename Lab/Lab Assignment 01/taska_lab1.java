import java.util.Scanner;

public class taska_lab1 {
    public static void main(String[] args) {
        Scanner RHT = new Scanner(System.in);

        int inp = RHT.nextInt();
        for (int i = 0; i < inp; i++) {
            int N = RHT.nextInt();

            if (N % 2 == 0) {
                System.out.println(N + " is an Even number.");
            } else {
                System.out.println(N + " is an Odd number.");

            }
        }

        RHT.close();
    }
}
