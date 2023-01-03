import java.io.*;
import java.util.*;

public class Main {
    /*
        아이디어
            - For문을 돌면서 모든 정점을 탐색한다
            - BFS를 사용하여 레벨 탐색을 실해하며 감귤을 전파 시킨다.
            - BFS 종료 후 귤밭에 0이 존재하면 -1 반환
        시간복잡도
            - O(N + N*(N-1) / 2) = 1000 + 1000*1000/2 < 3 * 10^8
        자료구조
            - 그래프
            - 방문: Boolean
            - Queue: BFS 저장소
     */
    static int N, M;
    static int[][] nums;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[M][N];
        int output = -1;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
                if(nums[i][j] == 1){
                    q.add(new int[]{i, j});
                }
            }
        }


        while (!q.isEmpty()){
            int qSize = q.size();
            while (qSize > 0){
                int[] position = q.poll();
                int y = position[0];
                int x = position[1];
                for(int dIndex = 0; dIndex < dx.length; dIndex++) {
                    int nextX = x + dx[dIndex];
                    int nextY = y + dy[dIndex];
                    if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || nums[nextY][nextX] != 0){
                        continue;
                    }

                    q.add(new int[]{ nextY, nextX });
                    nums[nextY][nextX] = 1;
                }

                qSize--;
            }
            output++;
        }

        for (int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if (nums[i][j] == 0){
                    output = -1;
                }
            }
        }

        System.out.print(output);
    }
}