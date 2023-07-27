import java.io.*;
import java.util.*;
public class Main {
    /*
        Algorithm & DS: DP, Sort
        Time: O(N*LogN), Space: O(1)

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // x, r을 1차원 그래프의 좌표로 변환
        // EX: [3, 1] => [2, 4]
        // O(N)
        for(int i = 0; i < N; i++){
            int x = arr[i][0], r = arr[i][1];
            arr[i][0] = x - r;
            arr[i][1] = x + r;
        }

        // 변환된 1차원 그래프를 [a, b]라고하면 a를 기준으로 오름차순 정렬
        // O(N*LogN)
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // 교차점이 있는지 확인
        /*
           (s1)       (e1)
            2          8
            |----------|
                |-----------|
                5           11
               (s2)         (e2)

           위 그림은 교차하는 케이스이다.
           만약, e1 >= s2 && e1 <= e2 (8 >= 5 && 8 <= 11)이면 교차하는 것이기때문에 No를 반환
           O(N)
         */
        for(int i = 1; i < N; i++){
            //int s1 = arr[i - 1][0], s2 = arr[i][0];
            //int e1 = arr[i - 1][1], e2 = arr[i][1];
            if(arr[i - 1][1] >= arr[i][0] && arr[i - 1][1] <= arr[i][1]){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}