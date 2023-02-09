import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    /*
        1 2 3 4 5 6 7 8

        1 2 3 4 K = 0
        2 3 4 5 K = 0

        [가입자 수, 판매 총액]
        아이디어
            1. K가 -1이 될때까지 right를 증가시킴(right는 홀수를 만났을때 감소 시킨다), 짝수를 만나면 localMax를 증가시키며, max와 수를 비교하며 크면 갱신
            2. 만약 K가 -1이면 left를 0이 될때까지 증가시킨다(left는 홀수를 만났을때 증가시킴), 짝수를만나면 localMax를 감소
        시간 복잡도
            O(N), N = 1000000 < 1 * 10^8
        자료구조 & 알고리즘
            투포인터

     */

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] nums = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int left, right, max, localMax;
            localMax = max = left = right = 0;

            while (right < N){
                if(K >= 0){
                    if(nums[right] % 2 == 0){
                        localMax++;
                        max = Math.max(max, localMax);
                    }
                    else {
                        K--;
                    }

                    right++;
                }
                else {
                    if(nums[left] % 2 == 0){
                        localMax--;
                    }
                    else {
                        K++;
                    }
                    left++;
                }
            }

            System.out.print(max);
        }
        catch (IOException ex) {

        }
    }
}