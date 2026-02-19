import java.io.*;

public class lab2task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a1 = Integer.parseInt(RHT.readLine());
        int[] alice = new int[a1];
        String[] parts = RHT.readLine().split(" ");
        for (int i = 0; i < a1; i++)   alice[i] = Integer.parseInt(parts[i]);
        int a2 = Integer.parseInt(RHT.readLine());
        int[] bob = new int[a2];
        parts = RHT.readLine().split(" ");
        for (int i = 0; i < a2; i++)     bob[i] = Integer.parseInt(parts[i]);
        int aa = 0;
        int bb = 0;
        while (aa < a1 && bb < a2) {
            if (alice[aa] <= bob[bb])    sb.append(alice[aa++]).append(" ");
            else    sb.append(bob[bb++]).append(" ");
        }
        while (aa < a1)    sb.append(alice[aa++]).append(" ");
        while (bb < a2)     sb.append(bob[bb++]).append(" ");
        System.out.println(sb.toString().trim());
    }
}
