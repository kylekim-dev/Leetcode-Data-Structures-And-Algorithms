/*
    1. 아이디어
        - Brute-Force는 시간 초과
        - 바이너리 서치를 사용함
        - 선행 조건인 A[N] 행렬을 정렬

    2. 시간 복잡도
        O(N*M), 100,000 * 100,000 > 1 * 10^6 실패
        O(2*N*logN ), 100,000 * 33 = 3,300,000 < 1억 미만
    3. 자료구조
        -

 */

import java.io.*;
import java.util.*;

public class Main {

    public static boolean binarySearch(int[] sortedNums, int left, int right, int target){
        if (left > right) {
            return false;
        }

        int mid = (left + right) / 2;

        if (sortedNums[mid] == target) {
            return true;
        }
        else if(sortedNums[mid] < target){
            return binarySearch(sortedNums, mid + 1, right, target);
        }
        else {
            return binarySearch(sortedNums, left, mid - 1, target);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = 0;
        int m = 0;
        int[] sortedNums;
        int target = 0;
        // Input Section end
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        sortedNums = new int[n];
        for (int i = 0; i < n; i++){
            sortedNums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        // Input Section end
        Arrays.sort(sortedNums);
        for (int i = 0; i < m; i++){
            target = Integer.parseInt(st.nextToken());
            System.out.print(binarySearch(sortedNums, 0, n - 1, target) ? 1 : 0);
            if(i < m - 1){
                System.out.println();
            }
        }
    }
}