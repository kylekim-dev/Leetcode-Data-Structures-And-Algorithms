import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();

            for(int i = N; i >= 1; i--){
                sb.append("*".repeat(i));
                sb.append("\n");
            }

            System.out.print(sb);
        }
        catch (IOException ex){

        }
    }
}