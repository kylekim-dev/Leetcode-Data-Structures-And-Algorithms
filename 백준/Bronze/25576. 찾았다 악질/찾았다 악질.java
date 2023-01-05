import java.io.*;
import java.util.*;

public class Main {
    /*
        아이디어
            - A와 B의 변화 추이의 합이 2000 이상이면 A와 B는 사이가 나쁘다
            - N - 1 / 2 < badCounter, badCounter = 변화 추이 합이 2000이상인 사람
        시간복잡도
            - O(N*M) 10,000 * 100 < 1 * 10^8
        자료구조

     */

    public static int N;
    public static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] ralpa = new int[M];
        int[][] others = new int[N-1][M];
        int badUserCounter = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            ralpa[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                others[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < others.length; i++){
            int total = 0;

            for(int j = 0; j < others[i].length; j++){
                total += Math.abs(others[i][j] - ralpa[j]);
            }

            if (total > 2000) {
                badUserCounter++;
            }
        }
        // 2 5 >> 2.5
        // 3 5 >> 2.5

        // 2 4 >> 2
        // 3 4 >> 2
        System.out.print(badUserCounter >= Math.round((N - 1) / 2.00) ? "YES" : "NO");
    }
}