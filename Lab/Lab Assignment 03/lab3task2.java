
import java.io.*;
import java.util.StringTokenizer;

public class lab3task2 {

    static int[] array1, Tmp;
    static long C = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        array1 = new int[n];
        Tmp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array1[i] = Integer.parseInt(st.nextToken());
        }

        sorter(array1, 0, n - 1);
        br.close();
        System.out.println(C);
    }

    public static void sorter(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            sorter(arr, left, mid);
            sorter(arr, mid + 1, right);

            counter(arr, left, mid, right);
            merger(arr, left, mid, right);
        }
    }

    public static void counter(int[] arr, int left, int avrg, int right) {
        for (int i = left; i <= avrg; i++) {
            int elem = arr[i];
            if (elem <= 0) {
                continue;
            }

            int tm = (int) Math.sqrt(elem);
            while ((long) tm * tm >= elem) {
                tm--;
            }
            while ((long) (tm + 1) * (tm + 1) < elem) {
                tm++;
            }
            int limit = tm;

            int baamdik = lower(avrg + 1, right, -limit);
            int daandik = upper(avrg + 1, right, limit);

            if (baamdik <= daandik) {
                C += (daandik - baamdik + 1);
            }
        }
    }

    public static void merger(int[] arr, int left, int avrg, int right) {
        int i = left, j = avrg + 1, k = left;

        while (i <= avrg && j <= right) {
            if (arr[i] <= arr[j]) {
                Tmp[k++] = arr[i++];
            } else {
                Tmp[k++] = arr[j++];
            }
        }

        while (i <= avrg) {
            Tmp[k++] = arr[i++];
        }

        while (j <= right) {
            Tmp[k++] = arr[j++];
        }

        for (int rh = left; rh <= right; rh++) {
            array1[rh] = Tmp[rh];
        }
    }

    public static int lower(int star, int last, int val) {
        int resultt = last + 1;
        while (star <= last) {
            int mid = (star + last) / 2;
            if (array1[mid] >= val) {
                resultt = mid;
                last = mid - 1;
            } else {
                star = mid + 1;
            }
        }
        return resultt;
    }

    public static int upper(int star, int last, int val) {
        int result = star - 1;
        while (star <= last) {
            int mid = (star + last) / 2;
            if (array1[mid] <= val) {
                result = mid;
                star = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return result;
    }
}
