/*
    1. 아이디어
        BFS를 사용하여 가장 깊은 레벨을 찾는다.

    2. 시간 복잡도
        O(N^M), 100*100 < 1 * 10^6
    3. 자료구조
        Queue

 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int globalMax = 0;
        int localMax = 0;
        int left = 0, right = 0;
        int[] temp = new int[n];

        st = new StringTokenizer(br.readLine());

        for(right = 0; right < n; right++){
            temp[right] = Integer.parseInt(st.nextToken());
        }

        for(right = 0; right < n; right++){
            if (right < k){
                localMax += temp[right];
                if(right == k - 1){
                    globalMax = localMax;
                }
            }
            else {
                localMax -= temp[left++];
                localMax += temp[right];
                globalMax = Math.max(localMax, globalMax);
            }
        }

        System.out.print(globalMax);
    }
}