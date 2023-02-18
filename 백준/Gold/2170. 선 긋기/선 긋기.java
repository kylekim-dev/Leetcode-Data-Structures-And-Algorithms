import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
        5
        1 3
        2 5
        3 5
        3 7
        6 7

        ---
         -----
          ----
              --

        아이디어
            2. 배열을 다음의 순서대로 정렬한다, 1순위로 x를 기준으로 오름 차순 정렬, 2순위로 y를 기준으로 오름차순 정렬을 한다.
            3. 우선순위 큐에서 pop을 하고 prev[2]에 저장한다
            4. pq가 빌때까지 이하를 반복한다
            5. pq를 pop하고 curr에 저장한다
            6.  만약 prev Y >= curr X이면, prevY = currY를 해주고 5번으로 돌아간다.
                만약 prev Y < curr X이면 maxLen += prevY - prevX를 해준다, 그리고 prev = curr해주고 5번으로 돌아간다.

        시간복잡도
            O(N) + O(NLogN) (1*10^6 + 2 * 10^7) < 1 * 10^8
        자료구조
            우선순위 큐
     */

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] nums = new int[N][2];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                nums[i][0] = Integer.parseInt(st.nextToken());
                nums[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nums, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] == o2[0]){
                        return Integer.compare(o1[1], o2[1]);
                    }
                    return Integer.compare(o1[0], o2[0]);
                }
            });

            int min = nums[0][0];//이전 선의 x좌표
            int max = nums[0][1];//이전 선의 y좌표
            int len = max - min;
            for(int i = 1; i < nums.length; i++) {
                if(min <= nums[i][0] && nums[i][1] <= max) { //현재 선이 이전 선에 포함된다면
                    continue;
                } else if(nums[i][0] < max) { //현재 선의 시작점이 이전 선에 포함된다면
                    len += nums[i][1] - max;
                } else { //현재 선과 이전 선이 겹치지 않는다면
                    len += nums[i][1] - nums[i][0];
                }
                min = nums[i][0];
                max = nums[i][1];
            }

            System.out.print(len);
//            int prevX = nums[0][0];
//            int prevY = nums[0][1];
//            int total = 0;
//
//            for(int i = 1; i < nums.length; i++){
//                int currX = nums[i][0];
//                int currY = nums[i][1];
//
//                // PrevY <= CurrX
//                if(prevY >= currX) {
//                    prevY = currY;
//                    continue;
//                }
//
//                total += (prevY - prevX);
//                prevX = currX;
//                prevY = currY;
//            }
//
//            total += (prevY - prevX);
//
//            System.out.print(total);
        }
        catch (IOException ex){

        }
    }
}