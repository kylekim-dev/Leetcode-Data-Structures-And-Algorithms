import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    4
    2 3 1
    5 2 4 1

    10^9
    10^14 * 100000
        아이디어
            1. prevMin = 아주 큰 값을 넣어준다.
            2. 0부터 N - 2까지 반복문을 선언
            3. prevMin = Min(prevMin, oil[i])
            4. total += prevMin * dist[i]

        시간복잡도
            O(N) 100000 < 1 * 10^8
            최대 오일의 값은 10^14이므로 Long Type으로 해결해야됨
        자료구조

     */

    public static long solution(long[] dist, long[] oil) {
        long total = 0;
        long minOil = Long.MAX_VALUE;

        for(int i = 0; i < dist.length; i++){
            minOil = Math.min(minOil, oil[i]);
            total += dist[i] * minOil;
        }

        return total;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long[] dist = new long[N-1];
            long[] oil = new long[N];
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N - 1; i++){
                dist[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                oil[i] = Long.parseLong(st.nextToken());
            }
            System.out.print(solution(dist, oil));
        }
        catch (IOException ex){

        }
    }
}