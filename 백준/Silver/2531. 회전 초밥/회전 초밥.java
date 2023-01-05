/*
    1. 아이디어
        - Two Pointer
        - 반복문을 0부터 N - k까지 실행한다
        - Map을 선언하고 쿠폰 c를 담는다
        - left ~ left + k의 범위에 각 요소들을 Map에 담고 Map.get(sushi[i]) + 1을 실행한다
        - 1.현재 해쉬 맵의 크기와 최대 갯수를 비교하여 큰놈을 최대 갯수에 업데이트해준다.
        - 2.left를 해쉬맵에서 차감한 후 left++;
        - 3.left+k를 해쉬맵에 추가 후 1번을 다시 실행해준다.
    2. 시간 복잡도
        - O(N), 30,000 < 1 *10^8
    3. 자료구조
        - 먹은 스시: HashMap<Integer>
        - 결과: Integer
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[N];
        int output = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int left = 0;
        int right = 0;

        map.put(c, 1);

        while(right < k){
            map.put(sushi[right], map.getOrDefault(sushi[right], 0) + 1);
            right++;
        }

        output = Math.max(output, map.size());

        while (left < N) {
            if(map.get(sushi[left]) <= 1){
                map.remove(sushi[left]);
            }
            else {
                map.put(sushi[left], map.get(sushi[left]) - 1);
            }

            map.put(sushi[right], map.getOrDefault(sushi[right], 0) + 1);

            output = Math.max(output, map.size());

            left += 1;
            right = (right + 1) % N;
        }

        System.out.print(output);
    }
}