
import java.io.*;

public class lab3task8 {

    static int[] pre, in, PST, posi;
    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));

        int iput = Integer.parseInt(RHT.readLine());
        in = new int[iput];
        pre = new int[iput];
        PST = new int[iput];
        posi = new int[iput + 1];

        String[] line1 = RHT.readLine().split(" ");
        for (int i = 0; i < iput; i++)
            in[i] = Integer.parseInt(line1[i]);

        String[] line2 = RHT.readLine().split(" ");
        for (int k = 0; k < iput; k++)
            PST[k] = Integer.parseInt(line2[k]);

        for (int i = 0; i < iput; i++)
            posi[in[i]] = i;

        index = 0;
        builder(0, 0, iput);
        for (int jk = 0; jk < iput; jk++) {
            System.out.print(pre[jk]);
            if (jk < iput - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        RHT.close();
    }

    static void builder(int postIn, int inIn, int SIZE) {
        if (SIZE <= 0) {
            return;
        }
        int RT = PST[postIn + SIZE - 1], rootidx = posi[RT], lefsize = rootidx - inIn;
        pre[index++] = RT;
        builder(postIn, inIn, lefsize);
        builder(postIn + lefsize, rootidx + 1, SIZE - lefsize - 1);
    }
}
