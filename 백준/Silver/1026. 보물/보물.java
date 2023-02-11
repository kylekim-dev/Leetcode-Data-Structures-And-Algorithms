import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
5
1 1 1 6 0
2 7 8 3 1


3
1 1 3
10 30 20
1 1 3
30 20 10


        아이디어
            1. A를 내림차순 우선순위 큐에 담는다
            2. B를 오름차순 우선순위 큐에 담는다
            3. 큐가 빌때까지 A와 B를 빼면서 S += A * B를 해준다.

        시간복잡도
            O(NLogN)
        자료구조
            prefixSum
     */

    public static int solution(int[] A, int[] B) {
        int S = 0;
        PriorityQueue<Integer> aq = new PriorityQueue<>();
        PriorityQueue<Integer> bq = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));

        for(int i = 0; i < A.length; i++){
            aq.offer(A[i]);
            bq.offer(B[i]);
        }

        while (!aq.isEmpty()){
            S += aq.poll() * bq.poll();
        }

        return S;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[N];

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }

            System.out.print(solution(A, B));
        }
        catch (IOException ex){

        }
    }
}