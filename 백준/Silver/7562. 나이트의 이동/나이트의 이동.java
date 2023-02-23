import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
        1 0 0 0 0 0 0 0
        0 0 1 0 0 0 0 0
        0 1 0 0 0 0 0 0
        0 0 0 0 0 0 0 0
        0 0 0 0 0 0 0 0
        0 0 0 0 0 0 0 0
        0 0 0 0 0 0 0 0
        0 0 0 0 0 0 0 0

        1 0 2 0 2 0 0 0
        0 0 1 0 0 0 0 0
        0 1 0 0 2 0 0 0
        0 0 0 2 0 0 0 0
        2 0 2 0 0 0 0 0
        0 0 0 0 0 0 0 0
        0 0 0 0 0 0 0 0
        0 0 0 0 0 0 0 0

        1 0 0 0 2 0 0 0
        0 0 1 0 0 0 3 0
        0 1 0 3 2 3 0 0
        3 0 0 2 3 0 3 0
        2 0 2 0 0 3 0 0
        3 0 0 0 3 0 0 0
        0 3 0 3 0 0 0 0
        0 0 0 0 0 0 0 0

        1 0 0 0 2 0 0 0
        0 0 1 0 0 0 3 0
        0 1 0 3 2 3 0 0
        3 0 0 2 3 0 3 0
        2 0 2 0 4 3 0 0
        3 4 0 0 3 4 0 0
        0 3 0 3 0 0 0 0
        0 4 0 0 0 4 0 0

        아이디어
            1.  6가지 범위에 있는 곳을 순차적으로 BFS 방문을 한다.
        시간복잡도
            O(N*N) = 100 * 100 < 1*10^8
        자료구조 및 알고리즘
            BFS
     */

    private static final int[] DR = { -2, -1, 1, 2, 2, 1, -1, -2 };
    private static final int[] DC = { 1, 2, 2, 1, -1, -2, -2, -1 };
    public static long solution(boolean[][] grid, int[] start, int[] end) {
        int count = 0;
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{ start[0], start[1] });
        grid[start[0]][start[1]] = true;

        while (!q.isEmpty()){
            int size = q.size();

            for(int c = 0; c < size; c++){
                int[] posi = q.poll();
                int currR = posi[0];
                int currC = posi[1];

                if(currR == end[0] && currC == end[1]){
                    return count;
                }

                for(int i = 0; i < DR.length; i++){
                    int nextR = currR + DR[i];
                    int nextC = currC + DC[i];

                    if(nextR < 0 || nextC < 0 || nextR >= grid.length || nextC >= grid.length || grid[nextR][nextC]){
                        continue;
                    }

                    q.add(new int[]{ nextR, nextC });
                    grid[nextR][nextC] = true;
                }
            }

            count++;
        }

        return -1;
    }

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int M = Integer.parseInt(st.nextToken());
                boolean[][] grid = new boolean[M][M];

                st = new StringTokenizer(br.readLine());
                int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
                st = new StringTokenizer(br.readLine());
                int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

                sb.append(solution(grid, start, end) + "\n");
            }

            System.out.print(sb);
        }
        catch (IOException ex){

        }
    }
}