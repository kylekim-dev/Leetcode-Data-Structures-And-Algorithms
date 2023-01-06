/*
    1. 아이디어
        - Stack사용
        - stack이 비어있는데 )를 만나면 No 리턴
        - 모든 프로세스를 이행했는데 stack이 비어있지 않으면 리턴

    2. 시간 복잡도
    3. 자료구조

 */

import java.io.*;
import java.util.*;

public class Main {

    public static boolean isVPS(String str){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ')'){
                if(stack.isEmpty()){
                    return false;
                }

                stack.pop();
            }
            else {
                stack.push(str.charAt(i));
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(br.readLine());

        for(int i = 0; i < k; i++){
            System.out.println(isVPS(br.readLine()) ? "YES" : "NO");
        }
    }
}