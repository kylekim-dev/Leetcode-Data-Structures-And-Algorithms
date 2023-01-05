/*
    1. 아이디어
        - 다익스트라 알고리즘으로 모든 출발 지점을 기준으로 최단거리 테이블을 만든다
        - X 번째 
        - 방문 시

    2. 시간 복잡도
        - O(N), 30,000 < 1 *10^8
    3. 자료구조
        - 먹은 스시: HashMap<Integer>
        - 결과: Integer
 */

import java.io.*;
import java.util.*;

public class Main {

    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] dijkstra;
        int[][] graph;
        int[] visit;
        int output = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[start][end] = w;
        }

        dijkstra = new int[N + 1][N + 1];

        for(int i = 1; i < N + 1; i++){
            visit = new int[N + 1];

            visit[i] = 1;
            // find min index
            for(int idx = 1; idx < N + 1; idx++){
                if(visit[idx] == 1){
                    continue;
                }

                dijkstra[i][idx] = graph[i][idx] == 0 ? INF : graph[i][idx];
            }

            for(int j = 1; j < N + 1; j++){
                // find min index
                int min = INF;
                int minIdx = 1;

                for(int idx = 1; idx < N + 1; idx++){
                    if(visit[idx] == 1){
                        continue;
                    }
                    min = Math.min(dijkstra[i][idx], min);
                    if(min == dijkstra[i][idx]){
                        minIdx = idx;
                    }
                }

                visit[minIdx] = 1;

                for(int idx = 1; idx < N + 1; idx++){
                    if(minIdx == idx || graph[minIdx][idx] == 0){
                        continue;
                    }
                    dijkstra[i][idx] = Math.min(dijkstra[i][minIdx] + graph[minIdx][idx], dijkstra[i][idx]);
                }
            }
        }

        for(int i = 1; i < N + 1; i++){
            if(X == i){
                continue;
            }

            output = Math.max(output, dijkstra[X][i] + dijkstra[i][X]);
        }

        System.out.print(output);
    }
}