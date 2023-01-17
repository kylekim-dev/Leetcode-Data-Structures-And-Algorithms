import java.io.*;
import java.util.*;

public class Main {
    /*
        아이디어
            1. 각 알파벳을 카운트하는 배열 int[26]을 선언한다.
            2. 주어진 문자열을 Upper case로 변환한다.
            3. 각 문자 - 62 를하여 알파뱃을 인덱스화한후 해당 배열의 숫자를 1씩 증가시킨다.
            4. 선언된 배열을 돌면서 가장 높은 숫자를 가진놈을 출력한다!

        시간복잡도
            O(N), 1,000,000 < 1 * 10^8
        자료구조
     */
    public static class Temp {
        public int count;
        public char character;

        public Temp(int count, Character character){
            this.count = count;
            this.character = character;
        }
    }

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken().toUpperCase();
        int[] alpabetCount = new int[26];
        PriorityQueue<Temp> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(-o1.count, -o2.count));

        for(int i = 0; i < s.length(); i++){
            alpabetCount[s.charAt(i) - 65]++;
        }

        for(int i = 0; i < alpabetCount.length; i++){
            pq.offer(new Temp(alpabetCount[i], (char)(i + 65)));
        }

        Temp first = pq.poll();
        Temp second = pq.isEmpty() ? new Temp(-1, '?') : pq.poll();

        if(first.count == second.count){
            System.out.print("?");
        }
        else {
            System.out.print(first.character);
        }
    }
}