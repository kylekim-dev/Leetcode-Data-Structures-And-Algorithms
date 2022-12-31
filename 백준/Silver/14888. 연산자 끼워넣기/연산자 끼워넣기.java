/*
    1. 아이디어
        - 깊이가 바뀌므로 BackTracking 사용
        - backtracking에서 재귀를 호출
        - nums[depth]은 깊에 따른 숫자 배치
        - visit으로 중복 제거!

    2. 시간 복잡도
        - O(N-1), 999 < 1 * 10^8, 중복 제거
    3. 자료구조
        - 방문체크: boolean[]
        - Output: int amx, int min
        - 연산자 배열: int[]
        - 순열 배열: int[]
 */

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static final int plus = 0, minors = 1, multi = 2, div = 3;
    static int[] operators, nums;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void backtracking(int depth, int output){
        if (depth == N){
            min = Math.min(min, output);
            max = Math.max(max, output);
            return;
        }

        for(int i = 0; i < N - 1; i++){
            if(visit[i]){
                continue;
            }
            visit[i] = true;
            if (operators[i] == plus)
                backtracking(depth + 1, output + nums[depth]);
            else if (operators[i] == minors)
                backtracking(depth + 1, output - nums[depth]);
            else if (operators[i] == multi)
                backtracking(depth + 1, output * nums[depth]);
            else if (operators[i] == div)
                backtracking(depth + 1, output / nums[depth]);

            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        visit = new boolean[N - 1];
        nums = new int[N];
        operators = new int[N-1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int tempindex = 0;
        for(int i = 0; i < 4; i++){
            int temp = Integer.parseInt(st.nextToken());
            for(int j = 0; j < temp; j++){
                operators[tempindex++] = i;
            }
        }

        backtracking(1, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }
}