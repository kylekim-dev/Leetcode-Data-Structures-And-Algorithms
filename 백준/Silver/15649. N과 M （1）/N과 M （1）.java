/*
    1. 아이디어
        - Backtracking
        - 재귀함수 안에서 for 돌면서 숫자 선택(방문 체크)
        - 재귀함수에서 M개를 선택할 경우 print해주기
    2. 시간복잡도
        - N! (N < 10 가능)
    3. 자료구조
        - 결과값 저장 int[]
        - 방문여부 체크  bool[]
 */

import java.io.*;
import java.util.*;

public class Main {
    static int m;
    static int n;
    static void recursion(boolean[] visit, int[] nums, int depth){
        if (m == depth) {
            for(int n : nums) {
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++){
            if (visit[i] == false){
                nums[depth] = i;
                visit[i] = true;
                recursion(visit, nums, depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[n + 1];
        int[] nums = new int[m];

        recursion(visit, nums, 0);
    }
}