
import java.io.*;
import java.util.StringTokenizer;

public class lab3task3 {

    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(RHT.readLine());
        long rht1 = Long.parseLong(st.nextToken());
        long rft2 = Long.parseLong(st.nextToken());
        int mod = 107;
        rht1 %= mod;
        long sdf1 = rft2 % (mod - 1);
        if (sdf1 == 0) {
            sdf1 = mod - 1;
        }
        long Final = 1;
        while (sdf1 > 0) {
            if (sdf1 % 2 == 1) {
                Final = (Final * rht1) % mod;
            }
            rht1 = (rht1 * rht1) % mod;
            sdf1 = sdf1 / 2;
        }

        System.out.println(Final);
        RHT.close();
    }
}
