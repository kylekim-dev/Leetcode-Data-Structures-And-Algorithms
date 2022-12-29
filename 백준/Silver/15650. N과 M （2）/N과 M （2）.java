/*
    1. 아이디어
        backtracking
        백트래킹 재귀함수 안에서 for문 돌면서 숫자 선택 (시작 인덱스를 부모 값 + 1)
        반환: Depth = M일떄

    2. 시간 복잡도

    3. 자료구조
        결과 값 저장 int[]
 */

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;

    static void backtracking(int[] nums, int depth, int start){
        if(depth == m){
            for (int n : nums){
                System.out.print(n + " ");
            }
            System.out.println();

            return;
        }

        for (int i = start; i <= n; i++){
            nums[depth] = i;
            backtracking(nums, depth + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] nums = new int[m];
        backtracking(nums, 0, 1);
    }
}