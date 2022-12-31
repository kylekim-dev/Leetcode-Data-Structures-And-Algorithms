/*
    1. 아이디어
        - Greedy 근사 접근 법을 사용한다
        - 1원이 존재하기 때문에 어떠한 경우에도 만들 수 있다

    2. 시간 복잡도
        O(N), 10 < 100M
    3. 자료구조
        - Output: int
        - Coins: int[]
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int remainBalance = K;
        int[] coins = new int[N];
        int usedCoinCount = 0;
        int tempUsedCoin = 0;
        int tempRemaingBalance = 0;

        for (int i = 0; i < N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i > -1; i--){
            tempUsedCoin = remainBalance / coins[i];
            tempRemaingBalance = remainBalance % coins[i];

            if(tempUsedCoin > 0){
                usedCoinCount += tempUsedCoin;
                remainBalance = tempRemaingBalance;
            }

            if (remainBalance <= 0){
                break;
            }
        }

        System.out.print(usedCoinCount);
    }
}