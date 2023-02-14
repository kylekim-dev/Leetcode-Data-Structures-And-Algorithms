import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
        55-50+30+40

        55-50-30+40

        55 -50
        -(30 + 40)

        아이디어
            1. 모든 숫자를 순자척으로 배열에 담는다
            2. 배열을 순회하면서 음수가 나오기 전까지 계속 더해준다
            3. 음수가 나오면 해당 값을 절대값으로 치환해주고 모든 갓을 빼준다.

        시간복잡도
            O(N) 100000 < 1 * 10^8
        자료구조

     */

//    public static long solution(long[] dist, long[] oil) {
//        long total = 0;
//        long minOil = Long.MAX_VALUE;
//
//        for(int i = 0; i < dist.length; i++){
//            minOil = Math.min(minOil, oil[i]);
//            total += dist[i] * minOil;
//        }
//
//        return total;
//    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            //int N = Integer.parseInt(st.nextToken());

            String str = st.nextToken() + "+";
            boolean isNegitive = false;
            int sum = 0;
            int localSum = 0;

            for(int i = 0; i < str.length(); i++){
                Character curr = str.charAt(i);
                if(curr == '+' || curr == '-'){
                    if(isNegitive){
                        localSum = localSum * -1;
                    }

                    sum += localSum;
                    localSum = 0;

                    if(curr == '-'){
                        isNegitive = true;
                    }
                    continue;
                }

                localSum = localSum * 10 + (curr - 48);
            }

            System.out.print(sum);
        }
        catch (IOException ex){

        }
    }
}