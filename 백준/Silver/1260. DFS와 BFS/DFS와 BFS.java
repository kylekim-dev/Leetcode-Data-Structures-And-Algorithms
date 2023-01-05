import java.io.*;
import java.util.*;

public class Main {
    /*
        아이디어
            - BFS를 사용 (Queue 사용)
        시간복잡도
            - O(4*N*N) 50 * 50 < 1 * 10^8
        자료구조


     */

    public static int N;
    public static int M;
    static int[][] graph;
    static boolean[] visited;
    public static void dfs(int target){
        visited = new boolean[N + 1];
        Stack<Integer> stack = new Stack<>();
        StringBuilder output = new StringBuilder();
        stack.add(target);

        while (!stack.isEmpty()){
            target = stack.pop();
            if(visited[target] == true){
                continue;
            }
            visited[target] = true;
            output.append(target + " ");

            for(int next = N; next > 0; next--){
                if(visited[next] || graph[target][next] == 0){
                    continue;
                }

                stack.push(next);
            }
        }

        System.out.println(output);
    }
    public static void bfs(int target){
        visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        StringBuilder output = new StringBuilder();
        q.add(target);

        while (!q.isEmpty()){
            target = q.poll();
            if(visited[target] == true){
                continue;
            }
            visited[target] = true;
            output.append(target + " ");

            for(int next = 1; next <= N; next++){
                if(visited[next] || graph[target][next] == 0){
                    continue;
                }

                q.add(next);
            }
        }

        System.out.println(output);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v2][v1] = graph[v1][v2] = 1;
        }

        dfs(target);
        bfs(target);
    }
}