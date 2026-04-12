
import java.util.*;

public class lab4task3 {
    public static void main(String[] args) {
        Scanner RHT = new Scanner(System.in);
        int same = RHT.nextInt();
        int[][] c = new int[same][same];

        for (int d = 0; d < same; d++) {
            int e = RHT.nextInt();
            for (int f = 0; f < e; f++) {
                int g = RHT.nextInt();
                setEdge(c, d, g);
            }
        }
        RHT.close();
        printMatrix(c);
    }

    static void setEdge(int[][] a1, int x, int yy) {
        a1[x][yy] = 1;
    }

    static void printMatrix(int[][] a) {
        for (int[] r : a) {
            for (int v : r)     System.out.print(v + " ");
            
            System.out.println();
        }
    }
}
