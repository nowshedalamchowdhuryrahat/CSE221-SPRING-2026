import java.io.*;
import java.util.*;

public class lab2task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(RHT.readLine());
        int inpSz = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        
        long[] Ar1 = new long[inpSz];
        st = new StringTokenizer(RHT.readLine());
        for (int k = 0; k < inpSz; k++)
            Ar1[k] = Long.parseLong(st.nextToken());

        long[][] Ar2 = new long[inpSz][2];
        for (int i = 0; i < inpSz; i++) {
            Ar2[i][0] = Ar1[i];
            Ar2[i][1] = i + 1;
        }

        for (int i = 0; i < inpSz - 1; i++) {
            int lowest = i;
            for (int j = i + 1; j < inpSz; j++) {
                if (Ar2[j][0] < Ar2[lowest][0] || (Ar2[j][0] == Ar2[lowest][0] && Ar2[j][1] < Ar2[lowest][1])) {
                    lowest = j;
                }
            }
            long tv = Ar2[i][0];
            long tI = Ar2[i][1];
            Ar2[i][0] = Ar2[lowest][0];
            Ar2[i][1] = Ar2[lowest][1];
            Ar2[lowest][0] = tv;
            Ar2[lowest][1] = tI;
        }

        for (int m = 0; m < inpSz; m++) {
            long target = x - Ar2[m][0];
            int lf = m + 1;
            int rg = inpSz - 1;
            while (lf < rg) {
                long totaL = Ar2[lf][0] + Ar2[rg][0];
                if (totaL == target) {
                    System.out.println(Ar2[m][1] + " " + Ar2[lf][1] + " " + Ar2[rg][1]);
                    return;
                } else if (totaL < target)
                    lf++;
                else
                    rg--;

            }

        }
        System.out.println(-1);
        RHT.close();
    }

}
