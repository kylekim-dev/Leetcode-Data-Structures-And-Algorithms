/*
    1. 아이디어
        backtracking
        백트래킹 재귀함수 안에서 for문 돌면서 숫자 선택
        반환: Depth = M일떄

    2. 시간 복잡도
        O(N^M), 7^7 < 1 * 10^6
    3. 자료구조
        결과 값 저장 int[]
 */

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] nums;

    static StringBuilder sb = new StringBuilder();

    static void backtracking(int depth){
        if(depth == m){
            for (int n : nums){
                sb.append(n).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++){
            nums[depth] = i;
            backtracking(depth + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[m];
        backtracking(0);
        System.out.println(sb);
    }
}