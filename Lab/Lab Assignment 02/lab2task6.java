import java.io.*;
import java.util.*;

public class lab2task6 {
    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        String[] input = RHT.readLine().split(" ");
        int siz = Integer.parseInt(input[0]);
        int dis = Integer.parseInt(input[1]);
        String[] s = RHT.readLine().split(" ");
        int[] ar1 = new int[siz];
        for (int sd = 0; sd < siz; sd++)    
            ar1[sd] = Integer.parseInt(s[sd]);
        HashMap<Integer, Integer> Cnt = new HashMap<>();
        int lft = 0;
        int maX  = 0;
        for (int df = 0; df < siz; df++) {
            Integer kn = Cnt.get(ar1[df]);
            if (kn == null)     Cnt.put(ar1[df], 1);
            else    Cnt.put(ar1[df], kn + 1);
            while (Cnt.size() > dis) {
                Cnt.put(ar1[lft], Cnt.get(ar1[lft]) - 1);
                if (Cnt.get(ar1[lft]) == 0) {
                    Cnt.remove(ar1[lft]);
                }
                lft++;
            }
            maX = Math.max(maX, df - lft + 1);
        }
        System.out.println(maX);
    }
}
