import java.io.*;
import java.util.*;

public class Main {
    /*




        아이디어
            15
            5 6 9 14 24 31 35 44 46 54
            1. 어큐뮬레이터 배열을 만든다 N, int accSum = arr[r] - arr[l]
            2. 만약 S > accSum Right을 증가시킨다.
            3. 만약 S <= accSum, result = Math.min(result, right-left) 한 후 left를 증가시킨다.
            4. 만약 2-3를 반복 후 right가 마지막 인덱스를 넘어가면 종료한다.
        시간 복잡도
            O(N), 100,000 < 50,000,000,

     */

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] accArray = new int[N + 1];
        int accSum = 0;
        final int INF = Integer.MAX_VALUE;
        int result = INF;
        int left, right;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++){
            accSum += Integer.parseInt(st.nextToken());
            accArray[i] += accSum;
        }

        accSum = 0;
        left = 0;
        right = 1;

        while (right < N + 1) {
            accSum = accArray[right] - accArray[left];

             if(accSum < S){
                right++;
            }
            else if(accSum >= S){
                result = Math.min(result, right - left);
                left++;
            }
        }

        System.out.print(result == INF ? 0 : result);
    }
}