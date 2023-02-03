import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            HashSet<Integer> setN = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                setN.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < M; i++){
                if(setN.contains(Integer.parseInt(st.nextToken()))){
                    sb.append(1 + " ");
                }
                else {
                    sb.append(0 + " ");
                }
            }

            System.out.print(sb);
        }
        catch (IOException ex){

        }
    }
}