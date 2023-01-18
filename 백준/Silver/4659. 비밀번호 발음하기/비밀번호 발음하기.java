import java.io.*;
import java.util.*;

public class Main {
    /*
        아이디어
            1. BFS 탐색을한다.
            2. 깊이가 최대 1000이므로 Queue 사용한다.

        시간복잡도
            O(N + LogN), 1,000,000 < 1 * 10^8
        자료구조
     */


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //int R = Integer.parseInt(st.nextToken());
        //int C = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while (true){
            String s = br.readLine();
            if(s.equals("end")){
                break;
            }

            Stack<Character> stack = new Stack<>();
            int count = 1;
            boolean pass1,pass2,pass3;
            pass1 = false;
            pass2 = true;
            pass3 = true;

            stack.add(s.charAt(0));
            if(s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i' || s.charAt(0) == 'o' || s.charAt(0) == 'u'){
                pass1 = true;
            }

            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
                    pass1 = true;

                    if(stack.peek() == 'a' || stack.peek() == 'e' || stack.peek()== 'i' || stack.peek() == 'o' || stack.peek() == 'u'){
                        count++;
                    }
                    else {
                        count = 1;
                    }
                }
                else {
                    if(stack.peek() == 'a' || stack.peek() == 'e' || stack.peek()== 'i' || stack.peek() == 'o' || stack.peek() == 'u'){
                        count = 1;
                    }
                    else {
                        count++;
                    }
                }

                if(count == 3){
                    pass2 = false;
                }

                if(stack.peek() == s.charAt(i) && (stack.peek() != 'e' && stack.peek() != 'o')){
                    pass3 = false;
                }

                stack.add(s.charAt(i));
            }

            if(pass1 && pass2 && pass3){
                sb.append("<" + s + "> is acceptable.\n");
            }
            else {
                sb.append("<" + s + "> is not acceptable.\n");
            }
        }

        System.out.print(sb);
    }
}