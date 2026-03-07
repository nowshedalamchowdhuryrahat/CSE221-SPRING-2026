
import java.io.*;
import java.util.StringTokenizer;

public class lab3task1 {

    static long countings = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader RHT = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(RHT.readLine());
        int[] array1 = new int[input];

        StringTokenizer st = new StringTokenizer(RHT.readLine());
        for (int i = 0; i < input; i++)
            array1[i] = Integer.parseInt(st.nextToken());

        sorter(array1, 0, input - 1);
        System.out.println(countings);
        for (int i = 0; i < array1.length; i++)
            System.out.print(array1[i] + " ");
        RHT.close();
    }

    public static void sorter(int[] arr, int left, int right) {
        if (left < right) {
            int Md = (left + right) / 2;
            sorter(arr, left, Md);
            sorter(arr, Md + 1, right);
            merger(arr, left, Md, right);
        }
    }

    public static void merger(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] bamDik = new int[n1];
        int[] daanDik = new int[n2];

        for (int i = 0; i < n1; i++)
            bamDik[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            daanDik[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (bamDik[i] <= daanDik[j])
                arr[k++] = bamDik[i++];
            else {
                arr[k++] = daanDik[j++];
                countings += (n1 - i);
            }

        }

        while (i < n1)
            arr[k++] = bamDik[i++];

        while (j < n2)
            arr[k++] = daanDik[j++];

    }
}
