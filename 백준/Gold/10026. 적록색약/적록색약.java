import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
        사람 R / G / B
        로봇 RG / B

        아이디어
            1.  N x N을 탐색하면서 방문하지 않은 배열을 BFS를 사용하여 탐색한다.
                만약 방문한 곳이 R이면 R만 탐색한다
            2.
        시간복잡도
            O(N*N) = 100 * 100 < 1*10^8
        자료구조 및 알고리즘
            BFS
     */

    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static long solution(int N, char[][] grid, boolean isNormal) {
        int count = 0;
        boolean[][] visit = new boolean[N][N];
        Stack<Integer> stackX = new Stack<>();
        Stack<Integer> stackY = new Stack<>();

        for(int y = 0; y < grid.length; y++){
            for(int x = 0; x < grid[y].length; x++){
                if(visit[y][x]){
                    continue;
                }

                char color = grid[y][x];
                count++;
                stackX.add(x);
                stackY.add(y);
                visit[y][x] = true;

                while (!stackY.isEmpty()){
                    int currX = stackX.pop();
                    int currY = stackY.pop();

                    for(int i = 0; i < dx.length; i++){
                        int nextX = currX + dx[i];
                        int nextY = currY + dy[i];

                        if(nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid.length || visit[nextY][nextX]){
                            continue;
                        }

                        if(isNormal && grid[nextY][nextX] != color){
                            continue;
                        }

                        if(!isNormal){
                            if(color == 'B' && (grid[nextY][nextX] == 'R' || grid[nextY][nextX] == 'G')){
                                continue;
                            }
                            if(color != 'B' && grid[nextY][nextX] == 'B'){
                                continue;
                            }
                        }

                        stackX.add(nextX);
                        stackY.add(nextY);
                        visit[nextY][nextX] = true;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            char[][] grid = new char[N][N];

            for(int i = 0; i < N; i++){
                String s = new StringTokenizer(br.readLine()).nextToken();

                for(int j = 0; j < N; j++){
                    grid[i][j] = s.charAt(j);
                }
            }


            System.out.print(solution(N, grid, true) + " " + solution(N, grid, false));
        }
        catch (IOException ex){

        }
    }
}