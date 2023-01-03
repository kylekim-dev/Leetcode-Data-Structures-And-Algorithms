import java.io.*;
import java.util.*;

public class Main {
    /*
        아이디어
            - 모든 정점을 양방향으로 연결한 그래프를 만든다
            - For문을 돌면서 모든 정점을 탐색한다
            - Queue를 사용해 BFS 탐색을 한다
            - HashSet을 사용해 방문 체크를 한다
        시간복잡도
            - O(N + N*(N-1) / 2) = 1000 + 1000*1000/2 < 3 * 10^8
        자료구조
            - 그래프
            - 방문: Boolean
            - Queue: BFS 저장소
     */
    static int N, M;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        graph = new int[N + 1][N + 1];
        int output = 0;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1][v2] = graph[v2][v1] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()){
            Integer v1 = q.poll();

            for(int v2 = 1; v2 <= N; v2++){
                if(!visited[v2] && graph[v1][v2] == 1){
                    q.add(v2);
                    visited[v2] = true;
                    output++;
                }
            }
        }

        System.out.print(output);
    }
}