import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void run(int A){
        if (A >= 90) System.out.print("A");
        else if (A >= 80) System.out.print('B');
        else if (A >= 70) System.out.print('C');
        else if (A >= 60) System.out.print('D');
        else System.out.print('F');
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());

            run(A);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}