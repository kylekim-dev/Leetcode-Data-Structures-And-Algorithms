/*
    1. 아이디어
        - 기존에 나왔던 숫자가 처음으로 다시 나올때까지 연산을 반복, 연산 결과 값은 해쉬맵의 key, 해당 index는 Val에 저장
        - 0부터 중복 숫자의 Index - 1까지 짜른 후 결과 값 반환
    2. 시간 복잡도
        - O(A)
    3. 자료구조
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;

        while (map.containsKey(A) == false){
            output.add(A);
            map.put(A, index++);
            int temp = 0;
            while (A > 0){
                temp = temp + (int)Math.pow(A % 10, P);
                A /= 10;
            }
            A = temp;
        }

        System.out.print(output.subList(0, map.get(A)).size());
    }
}