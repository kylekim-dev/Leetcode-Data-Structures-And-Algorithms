import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
        아이디어
            1. Circle Linked List를 구현한다

        시간복잡도
            
        자료구조
            링크드 리스트
     */

    public static int N;
    public static int M;
    public static int[][] nums;
    public static int[] cols;
    public static class Node {
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            Node head = new Node(1);
            Node curr = head;

            for(int i = 2; i <= N; i++){
                curr.next = new Node(i);
                curr = curr.next;
            }

            curr.next = head;

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M - 1; j++){
                    curr = curr.next;
                }
                sb.append(curr.next.val);

                curr.next = curr.next.next;

                if(i < N - 1){
                    sb.append(", ");
                }
            }

            System.out.print("<" + sb + ">");
        }
        catch (IOException ex){

        }
    }
}