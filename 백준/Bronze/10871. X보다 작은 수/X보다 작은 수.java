import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void run(int N, int X, int[] nums){
        StringBuilder sb = new StringBuilder();

        for (int n : nums) {
            if(n < X){
                sb.append(n + " ");
            }
        }

        System.out.print(sb);
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int[] nums = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            run(N, X, nums);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}