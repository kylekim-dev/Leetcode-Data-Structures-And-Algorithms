import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader((System.in)));
        int idx = 1;
        int maxIdx = 1;
        int max = 0;

        while (sc.hasNext()){
            int val = sc.nextInt();
            if(max < val){
                max = val;
                maxIdx = idx;
            }

            idx++;
        }

        sc.close();

        System.out.println(max);
        System.out.println(maxIdx);
    }
}