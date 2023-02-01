import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            /*
                영식 요금제: 10 * ((s / 30) + 1)
                민식 요금제: 15 * ((s / 60) + 1)

             */
            BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();

            int y = 0;
            int m = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                int sec = Integer.parseInt(st.nextToken());
                int yAmt = 10 * ((sec / 30) + 1);
                int mAmt = 15 * ((sec / 60) + 1);

                y += yAmt;
                m += mAmt;
            }

            if(y == m){
                System.out.println("Y M " + y);
            } else if (y > m) {
                System.out.println("M " + m);
            }
            else {
                System.out.println("Y " + y);
            }
        }
        catch (IOException ex){

        }
    }
}