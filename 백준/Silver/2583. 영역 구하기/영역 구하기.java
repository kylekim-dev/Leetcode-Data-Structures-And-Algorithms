import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
        - 입력되는 K개의 직사각형들이 모눈종이 전체를 채우는 경우는 없다.

        0 0 0 0 0 0 0 0
        0 1 0 0 0 0 0 0
        1 1 1 1 0 0 0 0
        1 1 1 1 0 0 0 0
        0 1 0 0 1 1 1 0
        0 0 0 0 1 1 1 0


        0 0 0 0 1 1 1 0
        0 1 1 0 1 1 1 0
        1 1 1 1 1 1 1 0
        1 1 1 1 1 0 0 0
        1 1 1 1 1 0 0 0
        0 1 1 0 0 0 0 0

        0 0 0 0 1 1 0
        0 1 0 0 1 1 0
        1 1 1 1 0 0 0
        1 1 1 1 0 0 0
        0 1 0 0 0 0 0



        아이디어
            1. M x N 정수 행열을 선언한다. M = row, N = col
            2. 시작 좌표 (sr, sc), 끝좌표 (er-1, ec-1)를 1로 채운다.
            3. 모든 좌표의 사각형을 채우면 BFS 탐색을하여 빈 영역의 크기를 반환하고, 그것을 오름차순 우선순위 큐에 담는다.
            5. 큐 사이즈를 출력한다, 그리고 큐의 값을 순서대로 나열 후 출력

        시간복잡도
            O(N*M) < 10000 * 10^8
        자료구조
            우선순위 큐
     */
    public static final int[] DX = { 0, 1, 0, -1 };
    public static final int[] DY = { -1, 0, 1, 0 };

    public static StringBuilder solution(int[][] grid){
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int y = 0; y < grid.length; y++){
            for(int x = 0; x < grid[y].length; x++){
                if(grid[y][x] != 0){
                    continue;
                }
                Queue<int[]> q = new ArrayDeque<>();

                q.add(new int[]{ x, y });
                grid[y][x] = 1;
                int size = 1;
                // BFS
                while (!q.isEmpty()){
                    int[] posi = q.poll();
                    int currX = posi[0];
                    int currY = posi[1];

                    for(int i = 0; i < DX.length; i++){
                        int nextX = currX + DX[i];
                        int nextY = currY + DY[i];

                        if(nextX < 0 || nextY < 0 || nextX >= grid[y].length || nextY >= grid.length || grid[nextY][nextX] != 0){
                            continue;
                        }

                        q.add(new int[]{ nextX, nextY });
                        grid[nextY][nextX] = 1;
                        size++;
                    }
                }

                pq.offer(size);
            }
        }

        sb.append(pq.size() + "\n");
        while (!pq.isEmpty()){
            sb.append(pq.poll() + " ");
        }

        return sb;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] grid = new int[M][N];

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int sx = Integer.parseInt(st.nextToken());
                int sy = Integer.parseInt(st.nextToken());
                int ex = Integer.parseInt(st.nextToken());
                int ey = Integer.parseInt(st.nextToken());

                for(int y = sy; y < ey; y++){
                    for(int x = sx; x < ex; x++){
                        grid[y][x] = 1;
                    }
                }
            }

            System.out.print(solution(grid));
        }
        catch (IOException ex){

        }
    }
}