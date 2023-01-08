/*
    1. 아이디어
        - Stack을 선언한다


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
        int N = Integer.parseInt(sc.nextLine());
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            String[] command = sc.nextLine().split(" ");
            if(command[0].equals("push")){
                stack.push(command[1]);
            } else if (command[0].equals("pop")) {
                if(stack.isEmpty()) sb.append(-1 + "");
                else sb.append(stack.pop());
            } else if (command[0].equals("size")) {
                sb.append(stack.size());
            } else if (command[0].equals("empty")) {
                sb.append(stack.isEmpty() ? "1" : "0");
            } else if (command[0].equals("top")) {
                if (stack.isEmpty()) sb.append(-1);
                else sb.append(stack.peek());
            }

            if(command[0].equals("push") == false){
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}