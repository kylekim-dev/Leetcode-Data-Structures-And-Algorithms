/*
    1. 아이디어
        - DP: Bottom-Up 방식 사용
        - 1, 2, 3, 5, 8 ...로 피보나치 수열의 성질을 갖는다

    2. 시간 복잡도
        O(N), 1000 < 100M
    3. 자료구조
        - dp: int[]
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[N + 1];
        final int DIV = 10007;
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= N; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % DIV;
        }

        System.out.print(dp[N]);
    }
}