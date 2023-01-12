/*
    1. 아이디어
        - 백트래킹
        - 방문한 알파뱃 처리 26사이즈 배열
        - 4 방향이 모두 가로막히거나, 배열 밖을 참조할때까지 재귀

    2. 시간 복잡도

    3. 자료구조
 */

import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int[][] map;
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { -1, 0, 1, 0};
    static int result = 0;

    public static void backtracking(int depth, int row, int col){
        if(isBlocked(row, col)){
            result = Math.max(result, depth);
            return;
        }

        for(int i = 0; i < dr.length; i++){
            int nextR = row + dr[i];
            int nextC = col + dc[i];

            if(nextR < 0 || nextC < 0 || nextR >= map.length || nextC >= map[row].length || visited[map[nextR][nextC]]){
                continue;
            }

            visited[map[nextR][nextC]] = true;
            backtracking(depth + 1, nextR, nextC);
            visited[map[nextR][nextC]] = false;
        }
    }

    public static boolean isBlocked(int row, int col){
        for(int i = 0; i < dr.length; i++){
            int nextR = row + dr[i];
            int nextC = col + dc[i];

            if(nextR < 0 || nextC < 0 || nextR >= map.length || nextC >= map[row].length || visited[map[nextR][nextC]]){
                continue;
            }

            return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);
        int R = Integer.parseInt(sc.next());
        int C = Integer.parseInt(sc.next());

        map = new int[R][C];
        visited = new boolean[26];

        for(int row = 0; row < R; row++){
            String s = sc.next();
            for(int col = 0; col < C; col++){
                map[row][col] = s.charAt(col) - 65;
            }
        }

        visited[map[0][0]] = true;
        backtracking(1, 0, 0);

        System.out.print(result);
        sc.close();
    }
}