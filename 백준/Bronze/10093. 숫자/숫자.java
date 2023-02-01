import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            StringBuilder sb = new StringBuilder();

            if(A == B){
                System.out.println(0);
                return;
            }

            if(A > B){
                long temp = A;
                A = B;
                B = temp;
            }
            for(long i = A + 1; i < B; i++){
                sb.append(i + " ");
            }

            System.out.println(B-A-1);
            System.out.print(sb.toString().trim());
        }
        catch (IOException ex){

        }
    }
}