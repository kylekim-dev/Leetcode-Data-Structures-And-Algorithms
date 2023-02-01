import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void run(int A){
        if (A >= 90) System.out.print("A");
        else if (A >= 80) System.out.print('B');
        else if (A >= 70) System.out.print('C');
        else if (A >= 60) System.out.print('D');
        else System.out.print('F');
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader((System.in)));
        int total = 0;
        int minOdd = Integer.MAX_VALUE;

        while (sc.hasNext()){
            int val = sc.nextInt();
            if(val % 2 == 1){
                total += val;
                minOdd = Math.min(minOdd, val);
            }
        }

        if(total == 0){
            System.out.println(-1);
        }
        else {
            System.out.println(total);
            System.out.println(minOdd);
        }
    }
}