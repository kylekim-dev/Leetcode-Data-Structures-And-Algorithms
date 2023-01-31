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

            TreeSet<Integer> tr = new TreeSet<>();
            StringBuilder sb = new StringBuilder();
            while (st.hasMoreTokens()){
                tr.add(Integer.parseInt(st.nextToken()));
            }


            while (!tr.isEmpty()){
                sb.append(tr.pollFirst() + " ");
            }

            System.out.println(sb);
            //run(A);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}