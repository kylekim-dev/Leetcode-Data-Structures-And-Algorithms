/*
    1. 아이디어
        - Two Pointer
        - 모든 합이 Integer 범위를 넘나? No
    2. 시간 복잡도
        - O(N), 10,000 < 0.5 * 10^8, 중복 제거
    3. 자료구조
        - Result: int
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int result = 0;
        Queue<Integer> q = new LinkedList<>();
        int num = 0;

        while (st.hasMoreElements() || !q.isEmpty()) {
            if(target > 0 && st.hasMoreElements()){
                num = Integer.parseInt(st.nextToken());
                target -= num;
                q.add(num);
            }
            else {
                if(target == 0){
                    result++;
                }

                target += q.poll();
            }
        }

        System.out.print(result);
    }
}