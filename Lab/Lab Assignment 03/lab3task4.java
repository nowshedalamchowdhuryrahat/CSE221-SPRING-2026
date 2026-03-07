import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lab3task4 {

    public static void main(String[] args) throws IOException {
        long mod = 1_000_000_007;
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();
        int testCases = Integer.parseInt(RHT.readLine().trim());

        while (testCases > 0) {
            testCases--;

            StringTokenizer nizer = new StringTokenizer(RHT.readLine());
            long a11 = Long.parseLong(nizer.nextToken());
            long a12 = Long.parseLong(nizer.nextToken());
            long a21 = Long.parseLong(nizer.nextToken());
            long a22 = Long.parseLong(nizer.nextToken());

            long X = Long.parseLong(RHT.readLine().trim());

           
            long r11 = 1, r12 = 0;
            long r21 = 0, r22 = 1;

 
            long b11 = a11, b12 = a12;
            long b21 = a21, b22 = a22;

            while (X > 0) {
         
                if ((X & 1) == 1) {
                    long temp11 = (r11 * b11 + r12 * b21) % mod;
                    long temp12 = (r11 * b12 + r12 * b22) % mod;
                    long temp21 = (r21 * b11 + r22 * b21) % mod;
                    long temp22 = (r21 * b12 + r22 * b22) % mod;
                    r11 = temp11;
                    r12 = temp12;
                    r21 = temp21;
                    r22 = temp22;
                }

                long temp11 = (b11 * b11 + b12 * b21) % mod;
                long temp12 = (b11 * b12 + b12 * b22) % mod;
                long temp21 = (b21 * b11 + b22 * b21) % mod;
                long temp22 = (b21 * b12 + b22 * b22) % mod;
                b11 = temp11;
                b12 = temp12;
                b21 = temp21;
                b22 = temp22;

                X = X / 2;
            }

            str.append(r11).append(' ').append(r12).append('\n');
            str.append(r21).append(' ').append(r22).append('\n');
        }

        System.out.print(str);
    }
}
