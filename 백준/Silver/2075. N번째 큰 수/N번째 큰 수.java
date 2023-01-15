/*
    메모리를 이용하는 방법
    pq 사용

    1. 아이디어
        - 백트래킹
        - 방문한 알파뱃 처리 26사이즈 배열
        - 4 방향이 모두 가로막히거나, 배열 밖을 참조할때까지 재귀

    2. 시간 복잡도

    3. 자료구조
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                pq.offer(sc.nextInt());
            }
        }

        while (N > 1){
            pq.poll();
            N--;
        }

        System.out.print(pq.poll());

        sc.close();
    }
}