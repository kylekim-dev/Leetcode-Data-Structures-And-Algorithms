/*
    1. 아이디어
        - 문자열을 Stack에 담아준다.
        - 1. 숫자를 만나면 자릿수를 카운트한다(Q)
        - 2. )를 만나면 기존에 세던 수를 스택에 넣고, Q = 0 초기화 후 1로 돌아간다
        - 3. (를 만나면 세던 수 Q와 다음 자릿수 K를 곱한다, 그리고 스택에서 Pop을 한 값과 더해준 뒤 Q에 업데이트해준다.
        - 4. 문자열 Stack이 empty가 될때까지 1번부터 반복 진행한다.
        - 주의할 점은 1((1234)) = 0 이라는 예외 상황 처리

    2. 시간 복잡도
        O(N), 50 < 2*10^8
    3. 자료구조
        Stack
 */

import java.io.*;
import java.util.*;

public class Main {

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String s = br.readLine();
        Stack<Character> strStack = new Stack<>();
        Stack<Integer> digitStack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            strStack.push(s.charAt(i));
        }

        int Q = 0;
        digitStack.push(0);
        while (!strStack.isEmpty()){
            Character c = strStack.pop();

            if(c == ')'){
                digitStack.push(Q);
                Q = 0;
            } else if (c == '(') {
                Character nextC = strStack.pop();

                if (nextC == '('){
                    Q = digitStack.pop();
                }
                else {
                    int K = Integer.parseInt(nextC + "");
                    Q = (K * Q) + digitStack.pop();
                }
            }
            else {
                Q++;
            }
        }

        while (!digitStack.isEmpty()){
            Q += digitStack.pop();
        }

        System.out.print(Q);
    }
}