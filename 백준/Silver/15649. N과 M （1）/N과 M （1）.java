import java.io.*;
import java.util.*;

public class Main {
    /*
    1. 아이디어
        - 백트래킹
    2. 시간복잡도
        - N! = 8! < 10 ^ 8 < 1s
    3. 자료구조 & 알고리즘
        - Backtracking
    */
    static int N, M;
    static int[] nums;
    static boolean[] visited;
    static StringBuilder output = new StringBuilder();
    public static void backtracking(int depth){
        if (M == depth) {
            for(int n : nums) {
                output.append(n).append(" ");
            }
            output.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++){
            if (!visited[i]){
                nums[depth] = i;
                visited[i] = true;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        nums = new int[M];

        backtracking(0);
        System.out.print(output);
    }
}
