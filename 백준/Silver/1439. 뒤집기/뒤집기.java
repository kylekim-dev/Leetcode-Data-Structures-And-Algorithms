import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
        아이디어
            1. 연속된 1의 패턴과 0의 패턴을 카운트 한다
            2  zeroC,oneC 둘중 작은 것을 반환한다.

        시간복잡도
            O(N) 1*10^6 < 1 * 10^8
        자료구조

     */

    public static int solution(String s) {
        int zeroCount = 0;
        int oneCount = 0;

        Character prev = s.charAt(0);

        if(prev == '1'){
            oneCount++;
        }
        else {
            zeroCount++;
        }

        for(int i = 1; i < s.length(); i++){
            Character curr = s.charAt(i);

            if(prev != curr){
                if(curr == '1'){
                    oneCount++;
                }
                else {
                    zeroCount++;
                }
            }

            prev = curr;
        }

        return Math.min(zeroCount, oneCount);
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();

            System.out.print(solution(S));
        }
        catch (IOException ex){

        }
    }
}