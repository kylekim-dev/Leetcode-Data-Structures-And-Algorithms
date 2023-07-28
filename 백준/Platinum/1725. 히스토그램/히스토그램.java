import java.io.*;
import java.util.*;

public class Main {

    /*

        2 1 4 5 1 3 3

        l   r   min max
        0   0   2   2
        0   1   1   2
        0   2   1   4   -> 2 < 4
        2   3   4   8
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] histogram = new int[N];

        for(int i = 0; i < histogram.length; i++){
            st = new StringTokenizer(br.readLine());
            histogram[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>(); // Increasing Monotonic Stack
        long maxArea = 0;

        for(int i = 0; i < histogram.length; i++){
            while (!stack.isEmpty() && histogram[stack.peek()] > histogram[i]){
                long h = histogram[stack.pop()];
                long w = stack.isEmpty() ? i : i - 1 - stack.peek();
                maxArea = Math.max(maxArea,  w * h);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()){
            long h = histogram[stack.pop()];
            long w = stack.isEmpty() ? histogram.length : histogram.length - 1 - stack.peek();
            maxArea = Math.max(maxArea,  w * h);
        }

        System.out.print(maxArea);
    }
}