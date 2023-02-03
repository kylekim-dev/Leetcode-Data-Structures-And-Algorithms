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
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int i = 0; i < N; i++){
                 pq.offer(Integer.parseInt(br.readLine()));
            }

            StringBuilder sb = new StringBuilder();

            while (!pq.isEmpty()){
                sb.append(pq.poll());
                sb.append("\n");
            }

            System.out.print(sb);
        }
        catch (IOException ex){

        }
    }
}