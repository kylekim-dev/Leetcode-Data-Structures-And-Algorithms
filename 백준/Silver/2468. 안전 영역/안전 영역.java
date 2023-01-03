/*
    1. 아이디어
        - N -> 0 까지 물의 높이를 내려가면서 BFS로 섬의 갯수를 반환함
        - 섬의 갯수가 하락 추세로 꺽이면 프로그램을 종료하고 최대 섬의 갯수를 반환
    2. 시간 복잡도
        - O(4*N*N*N) 4,000,000 < 1 *10^8
    3. 자료구조
        - visit: boolean[][]
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int waterHeight = 0;
        int[][] nums = new int[N][N];
        int max = Integer.MIN_VALUE;
        boolean[][] visited;
        final int[] dx = { 0, 1, 0, -1 };
        final int[] dy = { -1, 0, 1, 0 };

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
                waterHeight = Math.max(nums[i][j], waterHeight);
            }
        }

        // bfs
        while (waterHeight >= 0){
            Queue<Integer[]> q = new LinkedList<>();
            int islandCount = 0;
            visited = new boolean[nums.length][nums.length];

            for(int tempY = 0; tempY < N; tempY++){
                for(int tempX = 0; tempX < N; tempX++){
                    if(nums[tempY][tempX] > waterHeight && visited[tempY][tempX] == false){
                        q.add(new Integer[]{ tempX, tempY});
                        visited[tempY][tempX] = true;
                        islandCount++;

                        while (!q.isEmpty()){
                            Integer[] current = q.poll();
                            int x = current[0];
                            int y = current[1];

                            for(int i = 0; i < dx.length; i++){
                                int nextX = x + dx[i];
                                int nextY = y + dy[i];

                                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N){
                                    continue;
                                }
                                else if(nums[nextY][nextX] <= waterHeight || visited[nextY][nextX]){
                                    continue;
                                }

                                visited[nextY][nextX] = true;
                                q.add(new Integer[]{ nextX, nextY });
                            }
                        }
                    }
                }
            }
            max = Math.max(islandCount, max);
            waterHeight--;
        }

        System.out.print(max);
    }
}