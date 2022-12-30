import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    /*
        아이디어
            - 배열 nums를 DFS 재귀 함수를 사용하여 탐색
            - 재귀함수의 종료 조건은 인접 노드의 값이 모두 = 0이거나, 배열 인덱스를 벗어났을 때
            - 방문한 배열의 값을 0으로 전환
        시간복잡도
            - O(N*N) = 25 * 25 < 2 * 10^8
        자료구조
            - 지도: boolean 2차원 배열
            - 섬의 갯수: int 1차원 리스트
     */

    private static int[] dx = new int[]{ 0, 1, 0, -1 };
    private static int[] dy = new int[]{ -1, 0, 1, 0 };
    private static int n;
    private static boolean[][] map;
    public static int dfs(int x, int y){
        if (x < 0 || x >= n || y < 0 || y >= n || map[y][x] == false) {
            return 0;
        }

        map[y][x] = false;

        return 1 + dfs(x + dx[0], y + dy[0]) + dfs(x + dx[1], y + dy[1]) + dfs(x + dx[2], y + dy[2]) + dfs(x + dx[3], y + dy[3]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int y = 0; y < n; y++){
            String houses = br.readLine();
            for(int x = 0; x < n; x++){
                map[y][x] = houses.charAt(x) == '1';
            }
        }

        for (int y = 0; y < n; y++){
            for(int x = 0; x < n; x++){
                if (map[y][x]){
                    pq.add(dfs(x, y));
                }
            }
        }

        System.out.println(pq.size());
        while (pq.isEmpty() == false){
            System.out.print(pq.poll());
            if (pq.isEmpty() == false) {
                System.out.println();
            }
        }
    }
}