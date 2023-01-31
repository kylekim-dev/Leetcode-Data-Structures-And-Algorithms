import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int run(int num){
        /*
                0 -> 0
            문제
                9  -> 99 -> 98 -> 87
                26 -> 68
            1. 아이디어
                - 분모를 10으로 설정한다
                a. val != result까지 반복하는 반복문 선언
                - Result = 나머지 * 10 + 몫 + 나머지
                - operatingCount += 1를 한 후 a로 돌아간다.
            2. 시간복잡도
                ??
         */

        int next = num;
        int count = 0;
        final int OPERATOR = 10;

        while (num != next || count < 1){
            int a = next / OPERATOR;
            int b = next % OPERATOR;

            next = (b * OPERATOR) + (a + b) % OPERATOR;
            count++;
        }

        return count;
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            System.out.println(run(N));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}