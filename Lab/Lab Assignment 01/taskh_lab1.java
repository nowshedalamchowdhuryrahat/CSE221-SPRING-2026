import java.util.Scanner;

public class taskh_lab1 {
    public static void main(String[] args) {
        Scanner RHT = new Scanner(System.in);
       int N = RHT.nextInt();
        RHT.nextLine();
        String[] lines = new String[N];
        String[] names = new String[N];
        int[] timeVal = new int[N];
        for (int i = 0; i < N; i++) {
            lines[i] = RHT.nextLine();
            String line = lines[i];
            String[] parts = line.split(" ");
            names[i] = parts[0];
            int fgz = parts.length - 1;
            String timeStr = parts[fgz];
            String[] t = timeStr.split(":");
            int hh = Integer.parseInt(t[0]);
            int mm = Integer.parseInt(t[1]);
            timeVal[i] = hh * 60 + mm;  }
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                boolean swap = false;

                if (names[j].compareTo(names[j + 1]) > 0) {
                    swap = true;
                } else if (names[j].equals(names[j + 1])) {
                    if (timeVal[j] < timeVal[j + 1])     swap = true;
                    
                }
                if (swap) {
                    String tempLine = lines[j];
                    lines[j] = lines[j + 1];
                    lines[j + 1] = tempLine;
                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;
                    int tempTime = timeVal[j];
                    timeVal[j] = timeVal[j + 1];
                    timeVal[j + 1] = tempTime;
                }
            }
        }
        RHT.close();
        for (int i = 0; i < N; i++)    System.out.println(lines[i]);
    }}
