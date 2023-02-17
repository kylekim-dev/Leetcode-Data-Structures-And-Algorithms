import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
        아이디어
            1. 우선순위 큐에 모든 카드의 값을 담는다. O(NLogN) 
            2. 2개의 숫자를 Pop하고 그들을 더한 값을 두 번 큐에 push한다. O(MLogN)
            3. 2번을 M번 반복한다.
            4. 모든 숫자를 더한다.

        시간복잡도
            O(NLogN) + O(MLogN) + O(N) = 161,000 < 1*10^8
        자료구조 및 알고리즘

     */


    public static long solution(int[] A, int N, int M) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long sum = 0;

        for(int i = 0; i < A.length; i++){
            pq.offer((long)A[i]);
        }

        for(int i = 0; i < M; i++){
            long localSum = pq.poll() + pq.poll();
            pq.offer(localSum);
            pq.offer(localSum);
        }

        while (!pq.isEmpty()){
            sum += pq.poll();
        }

        return sum;
    }

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            System.out.print(solution(A, N, M));
        }
        catch (IOException ex){

        }
    }
}