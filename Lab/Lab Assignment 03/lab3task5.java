
import java.io.*;
import java.util.StringTokenizer;

public class lab3task5 {

    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(RHT.readLine());

        while (input-- > 0) {
            StringTokenizer st = new StringTokenizer(RHT.readLine());
            long a = Long.parseLong(st.nextToken());
            long size = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            long reSULT1 = 0;
            long reSULT2 = 1;
            long x = a % m;
            long xy = a % m;
            while (size > 0) {
                if (size % 2 == 1) {
                    reSULT1 = (reSULT1 + reSULT2 * x) % m;

                    reSULT2 = (reSULT2 * xy) % m;
                }
                long nxtx = (x + xy * x) % m;
                long nxtxy = (xy * xy) % m;
                x = nxtx;
                xy = nxtxy;
                size = size / 2;
            }

            System.out.println(reSULT1);
        }
        RHT.close();
    }
}
