import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        int[] arr = new int[5];


        for(int i = 0; i < 5; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        Arrays.sort(arr);
        System.out.println(total / 5);
        System.out.println(arr[2]);
    }
}