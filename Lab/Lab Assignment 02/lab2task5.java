import java.io.*;
import java.util.*;

public class lab2task5 {
    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(RHT.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        
        int[] a1 = new int[n];
        st = new StringTokenizer(RHT.readLine());
        for (int i = 0; i < n; i++)    a1[i] = Integer.parseInt(st.nextToken());

        int mxx = 0;
        long suM = 0;
        int lf = 0;

        for (int rg = 0; rg < n; rg++) {
            suM += a1[rg];

            while (suM > k && lf <= rg) {
                suM -= a1[lf];
                lf++;
            }

            mxx = Math.max(mxx, rg - lf + 1);
        }

        System.out.println(mxx);
        RHT.close();
    }
}
