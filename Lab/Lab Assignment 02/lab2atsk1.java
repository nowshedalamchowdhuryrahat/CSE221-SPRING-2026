import java.io.*;
 
public class lab2atsk1 {
    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        String[] ar1 = RHT.readLine().split(" ");
        int lengthArr =Integer.parseInt(ar1[0]);
        int totaL = Integer.parseInt(ar1[1]);
 
        long[] arr = new long[lengthArr];
        String[] ar2 = RHT.readLine().split(" ");
        for (int b =0; b< lengthArr; b++)   arr[b]= Long.parseLong(ar2[b]);
        int lft = 0;
        int rgt =lengthArr - 1;
        while (lft< rgt) {
            long NewTotaL= arr[lft] + arr[rgt   ];
            if (NewTotaL== totaL) {
             System.out.println((lft+1) + " " + (rgt+1));
                return;
            } 
            else if (NewTotaL< totaL)     lft++;          
            else         rgt--;         
        }
        System.out.println("-1");
    }
}