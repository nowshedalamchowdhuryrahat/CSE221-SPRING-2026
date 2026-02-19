import java.util.Scanner;

public class taske_lab1 {
  public static void main(String[] args) {
    Scanner RHT = new Scanner(System.in);
    int inpt = RHT.nextInt();
    int[] arr = new int[inpt];
    
    for (int i = 0; i < inpt; i++) arr[i] = RHT.nextInt();
    RHT.close();
    if (inpt == 1) {
      System.out.println("YES\n0");
      return;
    }
    if (inpt == 2) {
      if (arr[0] <= arr[1]) System.out.println("YES\n0");
      else System.out.println("NO");
      return;
    }
    
    int[] arr1 = new int[inpt];
    for (int i = 0; i < inpt; i++) arr1[i] = arr[i];
    manualSort(arr1);
    
    int evenSZ = (inpt + 1) / 2;
    int oddSZ = inpt / 2;
    
    int[] evenOrig = new int[evenSZ];
    int[] oddOrig = new int[oddSZ];
    int[] evenSorted = new int[evenSZ];
    int[] oddSorted = new int[oddSZ];
    
    for (int i = 0; i < inpt; i++) {
      if (i % 2 == 0) {
        evenOrig[i / 2] = arr[i];
        evenSorted[i / 2] = arr1[i];
      } else {
        oddOrig[i / 2] = arr[i];
        oddSorted[i / 2] = arr1[i];
      }
    }
    
    manualSort(evenOrig);
    manualSort(oddOrig);
    manualSort(evenSorted);
    manualSort(oddSorted);
    
    if (!arraysEqual(evenOrig, evenSorted) || !arraysEqual(oddOrig, oddSorted)) {
      System.out.println("NO");
      return;
    }
    
    int[] arr2 = new int[inpt];
    for (int i = 0; i < inpt; i++) arr2[i] = arr[i];
    
    int[][] op = new int[inpt * inpt][2]; 
    int cn = 0;
    
    for (int i = 0; i < inpt - 2; i++) {
      for (int j = inpt - 3; j >= i; j--) {
        if (arr2[j] > arr2[j + 2]) {
          int temp = arr2[j];
          arr2[j] = arr2[j + 2];
          arr2[j + 2] = temp;
          op[cn][0] = j + 1;
          op[cn][1] = j + 3;
          cn++;
        }
      }
    }
    
    System.out.println("YES");
    System.out.println(cn);
    for (int i = 0; i < cn; i++) {
      System.out.println(op[i][0] + " " + op[i][1]);
    }
    
    RHT.close();
  }
  
  public static void manualSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      int mnINDX = i;
      for (int j = i + 1; j < n; j++)
        if (arr[j] < arr[mnINDX]) mnINDX = j;
      if (mnINDX != i) {
        int temp = arr[i];
        arr[i] = arr[mnINDX];
        arr[mnINDX] = temp;
      }
    }
  }
  
  public static boolean arraysEqual(int[] a, int[] b) {
    if (a.length != b.length) return false;
    for (int i = 0; i < a.length; i++) 
      if (a[i] != b[i]) return false;
    return true;
  }
}
