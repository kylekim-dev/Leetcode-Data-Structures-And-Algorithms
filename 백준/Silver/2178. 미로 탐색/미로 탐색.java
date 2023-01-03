/*
    1. 아이디어
        - BFS 사용, 상우하좌순으로 자식을 탐색한다.
        - 재귀적으로 구현하며 종료 조건은 (N, M)에 도달하면 1을 반환, 모든 면이 벽, 0, 방문 됨으로
    2. 시간 복잡도
        - O(4*N*M), 4*100*100 = 40,000 < 1 * 10^8
    3. 자료구조
        - nums: int[][]
        - Output: int
        - dx, dy, dDepth: int[]
 */

import java.io.*;
import java.util.*;

public class Main {

    final static int[] DX = { 0, 1, 0, -1 };
    final static int[] DY = { -1, 0, 1, 0};
    static int[][] nums;
    static boolean[][] visited;
    static int globalMin = Integer.MAX_VALUE;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N][M];
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        for(int y = 0; y < N; y++){
            String temp = br.readLine();
            for(int x = 0; x < M; x++){
                nums[y][x] = Integer.parseInt(temp.charAt(x) + "");
            }
        }

        q.add(new int[] { 0, 0 });
        visited[0][0] = true;

        while (!q.isEmpty()){
            int[] data = q.poll();
            int x = data[0];
            int y = data[1];

            for(int i = 0; i < DX.length; i++){
                int nextX = x + DX[i];
                int nextY = y + DY[i];

                if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || nums[nextY][nextX] == 0 || visited[nextY][nextX]){
                    continue;
                }
                q.add(new int[] { nextX, nextY });
                nums[nextY][nextX] = nums[y][x] + 1;
                visited[nextY][nextX] = true;
            }
        }

        System.out.print(nums[N - 1][M - 1]);
    }
}