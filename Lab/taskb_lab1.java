import java.util.Scanner;

public class taskb_lab1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < l; i++) {
            String line = sc.nextLine();
            String[] Narr = line.split(" ");
            int a = Integer.parseInt(Narr[1]);
            String oper = Narr[2];
            int b = Integer.parseInt(Narr[3]);
            double Res = 0;
            if (oper.equals("+")) {
                Res = a + b;
            } else if (oper.equals("-")) {
                Res = a - b;
            } else if (oper.equals("*")) {
                Res = a * b;
            } else if (oper.equals("/")) {
                Res = (double) a / b;
            }
            System.out.printf("%.6f%n", Res);
        }

        sc.close();
    }
}
