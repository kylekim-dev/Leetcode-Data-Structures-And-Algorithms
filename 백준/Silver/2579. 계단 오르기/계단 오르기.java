import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
        6
        10 20 15 25 24 20
        70 65 60 45 44 20


        아이디어
            1. 맨 마지막 계단부터 역순으로 계단 내리기를 한다
            2. canNext가 true인 경우 아래의 로직을 실행한다.
                - curr + 1 >= curr + 2이면 flag = false, maxSum[curr] += maxSum[curr + 1]
            3. canNext가 false인 경우, canNext = true, maxSum[curr] += maxSum[curr + 2]
            4. i가 0일때까지 2,3을 반복한다.
        시간복잡도
            O(N)
        자료구조
            prefixSum
     */

    public static int solution(int[] A) {
        int n = A.length;
        int[] dp = new int[n];

        if(n < 3){
            int total = 0;

            for(int val : A){
                total += val;
            }

            return total;
        }

        dp[0] = A[0];
        dp[1] = Math.max(A[0]+A[1],A[1]);
        dp[2] = Math.max(A[0]+A[2],A[1]+A[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-2]+A[i], A[i-1]+A[i]+dp[i-3]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] A = new int[N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                A[i] = Integer.parseInt(st.nextToken());
            }

            System.out.print(solution(A));
        }
        catch (IOException ex){

        }
    }
}