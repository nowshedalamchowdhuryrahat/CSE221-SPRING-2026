
import java.io.*;
import java.util.StringTokenizer;

public class lab3task7 {

    static int[] pre, in, post, posi;
    static int indx;

    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));

        int inpuT = Integer.parseInt(RHT.readLine());
        in = new int[inpuT];
        pre = new int[inpuT];
        post = new int[inpuT];
        posi = new int[inpuT + 1];

        StringTokenizer st = new StringTokenizer(RHT.readLine());
        for (int i = 0; i < inpuT; i++)
            in[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(RHT.readLine());
        for (int i = 0; i < inpuT; i++)
            pre[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < inpuT; i++)
            posi[in[i]] = i;

        indx = 0;
        builder(0, 0, inpuT);
        for (int i = 0; i < inpuT; i++) {
            System.out.print(post[i]);
            if (i != inpuT - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        RHT.close();
    }

    static void builder(int preIn, int inIn, int sz) {
        if (sz == 0)
            return;

        int rt = pre[preIn], rootidx = posi[rt], lefsiz = rootidx - inIn;
        builder(preIn + 1, inIn, lefsiz);
        builder(preIn + 1 + lefsiz, rootidx + 1, sz - lefsiz - 1);
        post[indx] = rt;
        indx++;
    }
}
