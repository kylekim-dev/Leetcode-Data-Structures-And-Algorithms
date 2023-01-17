import java.io.*;
import java.util.*;

public class Main {
    /*

     */

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if(A < B){
            System.out.print("<");
        }
        else if(A > B){
            System.out.print(">");
        }
        else {
            System.out.print("==");
        }
    }
}