import java.io.*;
import java.util.*;

public class Main {
    /*
        0 = lose, 1 = win
        dp[1] = 1
        dp[2] = 0
        dp[3] = 1
        dp[4] = 0 dp[3] or dp[1], 1 1 = Starter lose, 0
        dp[5] = 1 dp[5 - 1] or dp[5 - 3], 0 0 = Starter win 1
        dp[6] = 0 dp[5] or dp[3], 1 1 = starter lose, 0
        dp[7] = 1 dp[6] or dp[4], 0 0 = starter win 1

        아이디어
            홀수 = SK
            짝수 = CY
     */
    static int N;
    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());

        System.out.print(N % 2 == 1 ? "SK" : "CY");
    }
}