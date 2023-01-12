import java.io.*;
import java.util.*;

public class Main {
    /*
        1 1 3 1 2

        max[] = 3 3 3 2 2
        reg[] = 1 1 3 1 2
              = 2 2 0 1 0

        아이디어
            1. 주식 가격을 저장할 배열 stock[]을 선언
            2. 오른쪽부터 왼쪽으로 탐색하면 가장 큰 수를 저장하는 배열 max[] 선언한다
            3. 배열을 탐색하면서 maxProfix += max[i] - stock[i]을해준다.
        시간 복잡도
            O(2*N), 2,000,000 < 1 * 10^8
        자료구조
            int stock[]
            int max[]
            int maxProfix
     */
    static int T;
    static int N;
    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(st.nextToken());

        for(int r = 0; r < T; r++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long[] max = new long[N];
            long[] stock = new long[N];
            long maxProfit = 0;

            for(int c = 0; c < N; c++){
                stock[c] = Integer.parseInt(st.nextToken());
            }

            long prevMax = 0;
            for(int c = N - 1; c > -1; c--){
                prevMax = Math.max(prevMax, stock[c]);
                max[c] = prevMax;
            }

            for(int c = 0; c < N; c++){
                maxProfit = maxProfit + max[c] - stock[c];
            }
            sb.append(maxProfit);
            sb.append("\n");
        }

        System.out.print(sb.toString().trim());
    }
}