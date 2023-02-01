import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

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
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int win = 0;

            if(A == B && B == C){
                win += 10000 + A * 1000;
            } else if (A == B || A == C) {
                win += 1000 + A * 100;
            }
            else if(B == C){
                win += 1000 + B * 100;
            }
            else {
                win += Math.max(A, Math.max(B, C)) * 100;
            }

            System.out.println(win);
            //run(A);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}