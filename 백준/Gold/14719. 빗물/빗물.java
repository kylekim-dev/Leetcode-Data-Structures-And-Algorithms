import java.io.*;
import java.util.*;

public class Main {
    /*
        아이디어
            - 왼쪽의 가장 높은 기둥, 오른쪽의 가장 높은 기둥 사이에 물이 고인다
            - 고이는 물의 높이는 min(leftMax, rightMax) - nums[i] 로 정의 할 수 있다. (nums[i]는 현재 기둥의 높이를 말한다)
            - 위의 공식을 0 부터 i까지 반복문을 돌면서 모두 더해주면 빗물의 총량을 구할 수 있다.
        시간복잡도
            - O(N) 500 < 1 * 10^8
        자료구조
            - 왼쪽 가장 높은 기둥들: int[]
            - 오른쪽 가장 높은 기둥들: int[]
            - 기둥 높이 정보: int[]
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] heights = new int[W];
        int[] leftMax = new int[W];
        int[] rightMax = new int[W];
        int waterArea = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++){
            heights[i] = Integer.parseInt(st.nextToken());
        }

        leftMax[0] = heights[0];
        rightMax[W - 1] = heights[W - 1];

        for(int i = 1; i < W; i++){
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }

        for(int i = W - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }

        for(int i = 0; i < W; i++){
            waterArea += Math.min(leftMax[i], rightMax[i]) - heights[i];
        }

        System.out.print(waterArea);
    }
}