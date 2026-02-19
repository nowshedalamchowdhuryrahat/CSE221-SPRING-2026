import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class lab2task8 {
    public static void main(String[] args) throws IOException {
        BufferedReader ml = new BufferedReader(new InputStreamReader(System.in));
        int sT = Integer.parseInt(ml.readLine());
        
        for (int a = 0; a < sT; a++) {
            String[] b = ml.readLine().split(" ");
            long c = Long.parseLong(b[0]); 
            long d = Long.parseLong(b[1]); 
            
            long e = c + (c - 1) / (d - 1);
            System.out.println(e);
        }
    }
}