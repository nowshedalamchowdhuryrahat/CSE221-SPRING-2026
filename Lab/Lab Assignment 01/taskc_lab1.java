import java.util.Scanner;

public class taskc_lab1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt();
        for (int l = 0; l < limit; l++) {
            long n = sc.nextLong();
            long Total = (n * (n + 1)) / 2;
            System.out.println(Total);
        }
        sc.close();
    }
}
