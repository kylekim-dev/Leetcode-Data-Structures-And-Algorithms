import java.io.*;
import java.util.*;
public class Main {

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

        for(int i = 0; i < N; i++){
            int x = arr[i][0], r = arr[i][1];
            arr[i][0] = x - r;
            arr[i][1] = x + r;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        for(int i = 1; i < N; i++){
            int s1 = arr[i - 1][0], s2 = arr[i][0];
            int e1 = arr[i - 1][1], e2 = arr[i][1];
            if(s1 <= s2 && e1 <= e2 && s2 <= e1){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}