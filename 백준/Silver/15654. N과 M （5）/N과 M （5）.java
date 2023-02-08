import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
        아이디어
            - 백트래킹을 사용한다

        시간복잡도
            O(N!) N = 8 < 2*10^8
        자료구조
            백트리킹
            해쉬맵
            수의 최대 길이는 10^8 이므로 int
     */

    public static int N,M;
    public static int[] nums;
    public static StringBuilder output;
    public static boolean[] visit;
    public static void solution(int depth, Stack<Integer> stack) {
        if(depth >= M){
            StringBuilder sb = new StringBuilder();
            for (Object val : stack.toArray()) {
                sb.append(val + " ");
            }

            output.append(sb.append("\n"));
            return;
        }

        for(int i = 0; i < visit.length; i++){
            if(visit[i]){
                continue;
            }
            visit[i] = true;
            stack.push(nums[i]);
            solution(depth + 1, stack);
            stack.pop();
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            nums = new int[N];
            output = new StringBuilder();
            visit = new boolean[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nums);

            solution(0, new Stack<>());
            System.out.print(output);
        }
        catch (IOException ex){

        }
    }
}