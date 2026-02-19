import java.io.*;
import java.util.*;

public class lab2task7 {

    public static int lowerBound(long[] a1, long key) {
        int lower = 0;
        int upper = a1.length;
        while (lower < upper) {
            int avrg = (lower + upper)/ 2;
            if (a1[avrg] >= key)       upper = avrg;          
            else                       lower = avrg + 1;         
        }
        return lower;
    }
    public static int upperBound(long[] a2, long key) {
      int lower1 = 0;
        int upper1 = a2.length;
        while (lower1 < upper1) {
            int avrg1 = (lower1 + upper1)/ 2;
            if (a2[avrg1] > key)      upper1 = avrg1;           
            else                      lower1 = avrg1 + 1;         
        }
        return lower1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(RHT.readLine());
        int input = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        long [] ar1 = new long[input];
        st = new StringTokenizer(RHT.readLine());
        for (int i = 0; i < input; i++)     ar1[i] = Long.parseLong(st.nextToken());
        for (int k = 0; k < q; k++) {
            st = new StringTokenizer(RHT.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            int l = lowerBound(ar1, x);
            int r = upperBound(ar1, y);
            System.out.println(r - l);
        }
        RHT.close();
    }
}
