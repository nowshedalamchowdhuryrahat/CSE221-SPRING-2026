import java.io.*;
import java.util.*;

public class lab2task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(RHT.readLine());
        int fL = Integer.parseInt(st.nextToken());
        int sL = Integer.parseInt(st.nextToken());
        int tnv = Integer.parseInt(st.nextToken());
        int[] ar1 = new int[fL];
        int[] ar2 = new int[sL];
        
        st = new StringTokenizer(RHT.readLine());
        for (int f = 0; f < fL; f++)  ar1[f] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(RHT.readLine());
        for (int g = 0; g < sL; g++)  ar2[g] = Integer.parseInt(st.nextToken());
        long bestdis = Long.MAX_VALUE;
        int p1 = 0;
        int p2 = sL - 1;
        int ind1 = 0;
        int ind2     = 0;
        while (p1 < fL && p2 >= 0) {
            long totaL = (long) ar1[p1] + ar2[p2];
            long Diff = Math.abs(totaL - tnv);
            if (Diff < bestdis) {
                bestdis = Diff;
                ind1 = p1;
                ind2 = p2;
            }
            if (totaL < tnv)   p1++;
            else   p2--;
        }
        System.out.println((ind1 + 1) + " " + (ind2 + 1));
        RHT.close();
    }
}