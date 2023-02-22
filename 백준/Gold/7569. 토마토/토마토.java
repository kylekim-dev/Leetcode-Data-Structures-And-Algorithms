import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
        - 입력되는 K개의 직사각형들이 모눈종이 전체를 채우는 경우는 없다.


        아이디어

        시간복잡도
            O(N*M*H) < 10000 * 10^8
        자료구조
            우선순위 큐
     */
    public static final int[] DX = { 0, 1, 0, -1, 0, 0 };
    public static final int[] DY = { -1, 0, 1, 0, 0, 0 };
    public static final int[] DZ = { 0, 0, 0, 0, 1, -1 };

    public static int solution(int[][][] grid, int H, int N, int M){
        int c = 0;
        Queue<int[]> q = new ArrayDeque<>();

        for(int h = 0; h < grid.length; h++){
            for(int n = 0; n < grid[h].length; n++){
                for(int m = 0; m < grid[h][n].length; m++){
                    if(grid[h][n][m] == 1){
                        q.add(new int[]{ h, n, m });
                    }
                }
            }
        }

        while (!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] posi = q.poll();
                int currZ = posi[0];
                int currY = posi[1];
                int currX = posi[2];

                for(int j = 0; j < DX.length; j++){
                    int nextZ = currZ + DZ[j];
                    int nextY = currY + DY[j];
                    int nextX = currX + DX[j];

                    if(nextZ < 0 || nextZ >= H || nextY < 0 || nextY >= N || nextX < 0 || nextX >= M || grid[nextZ][nextY][nextX] != 0){
                        continue;
                    }

                    grid[nextZ][nextY][nextX] = 1;
                    q.add(new int[]{ nextZ, nextY, nextX });
                }
            }

            if(!q.isEmpty()){
                c++;
            }
        }

        for(int h = 0; h < grid.length; h++){
            for(int n = 0; n < grid[h].length; n++){
                for(int m = 0; m < grid[h][n].length; m++){
                    if(grid[h][n][m] == 0){
                        return -1;
                    }
                }
            }
        }

        return c;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            int[][][] grid = new int[H][N][M];

            for(int h = 0; h < H; h++){
                for(int n = 0; n < N; n++){
                    st = new StringTokenizer(br.readLine());

                    for(int m = 0; m < M; m++){
                        grid[h][n][m] = Integer.parseInt(st.nextToken());
                    }
                }
            }

            System.out.print(solution(grid, H, N, M));
        }
        catch (IOException ex){

        }
    }
}