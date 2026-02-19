import java.util.*;

public class taskf_lab1 {
 public static void main(String[] args) {
        Scanner RHT = new Scanner(System.in);
      int totalin =RHT.nextInt();
        RHT.nextLine();
        int[] arr = new int[totalin];


        String line = RHT.nextLine();
       String[] Narr= line.split(" ");
        for(int i = 0;i < Narr.length; i++) {
           arr[i] =Integer.parseInt(Narr[i]);
        }
        boolean CK =true;
      while(CK) {
            CK =false;
            for (int i= 0; i< totalin -1; i++) {
              if (arr[i] % 2== arr[i + 1] % 2 && arr[i]> arr[i + 1]) {
                    int temp =arr[i];
                  arr[i] =arr[i + 1];
                    arr[i + 1]= temp;
                  CK = true;
                }
            }
        }
        for(int K= 0; K< totalin; K++)    System.out.print(arr[K] + " ");
        
        RHT.close();
    }}