
import java.io.*;
import java.util.StringTokenizer;

public class lab3task6 {
    static int[] array1;
    static int[] result;
    static int INDEX = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        int INPUT = Integer.parseInt(RHT.readLine());
        array1 = new int[INPUT];
        result = new int[INPUT];

        StringTokenizer st = new StringTokenizer(RHT.readLine());
        for (int i = 0; i < INPUT; i++)
            array1[i] = Integer.parseInt(st.nextToken());

        find(0, INPUT - 1);
        for (int k = 0; k < INPUT; k++) {
            System.out.print(result[k]);
            if (k != INPUT - 1)
                System.out.print(" ");
        }
        System.out.println();
        RHT.close();
    }

    static void find(int LEFT, int RIGHT) {
        if (LEFT > RIGHT)
            return;
        int mid = (LEFT + RIGHT) / 2;
        result[INDEX++] = array1[mid];
        find(LEFT, mid - 1);
        find(mid + 1, RIGHT);
    }
}
