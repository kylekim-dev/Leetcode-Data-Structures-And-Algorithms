import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
        T = 테스트 케이스 갯수
        M = 가로
        N = 세로
        K = 배추 심어져 갯수

        아이디어
            1. 배열 모두를 돌면서 1을 만나면 2번을 반복한다
            2. BFS탐색을하고 4방향에 1이 있으면 0으로만들면서 지속적으로 탐색한다
            3. BFS 탐색이 끝나면 count한다
        시간복잡도
            O(N*M) < 50*50 * 10^8
        자료구조
            우선순위 큐
     */
    public static final int[] DX = { 0, 1, 0, -1 };
    public static final int[] DY = { -1, 0, 1, 0 };

    public static int solution(int[][] grid, int M, int N){
        int c = 0;

        for(int y = 0; y < N; y++){
            for(int x = 0; x < M; x++){
                // BFS
                if(grid[y][x] == 1){
                    c++;
                    Queue<int[]> q = new ArrayDeque<>();
                    grid[y][x] = 0;
                    q.add(new int[]{y, x});

                    while (!q.isEmpty()){
                        int[] posi = q.poll();
                        int currY = posi[0];
                        int currX = posi[1];

                        for(int i = 0; i < DX.length; i++){
                            int nextY = currY + DY[i];
                            int nextX = currX + DX[i];

                            if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || grid[nextY][nextX] == 0){
                                continue;
                            }
                            grid[nextY][nextX] = 0;
                            q.add(new int[]{nextY, nextX});
                        }
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
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            HashMap<String, String[]> teamAndMembers = new HashMap<>();
            HashMap<String, String> memberAndTeam = new HashMap<>();
            StringBuilder sb = new StringBuilder();

            for(int n = 0; n < N; n++){
                String team = new StringTokenizer(br.readLine()).nextToken();
                int numMember = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
                String[] arr = new String[numMember];

                for(int i = 0; i < numMember; i++){
                    String name = new StringTokenizer(br.readLine()).nextToken();
                    memberAndTeam.put(name, team);
                    arr[i] = name;
                }

                Arrays.sort(arr);
                teamAndMembers.put(team, arr);
            }

            for(int m = 0; m < M; m++){
                String key = new StringTokenizer(br.readLine()).nextToken();
                int num = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
                if(num == 0){
                    for(String name : teamAndMembers.get(key)){
                        sb.append(name + "\n");
                    }
                }
                else {
                    sb.append(memberAndTeam.get(key) + "\n");
                }
            }

            System.out.print(sb);
        }
        catch (IOException ex){

        }
    }
}