import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
        아이디어
            1.
        시간복잡도
            O(N*N) = 100 * 100 < 1*10^8
        자료구조 및 알고리즘
     */

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            HashMap<String, String> map = new HashMap<>();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                map.put(st.nextToken(), st.nextToken());
            }

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                sb.append( map.get(st.nextToken()) + "\n");
            }

            System.out.print(sb);
        }
        catch (IOException ex){

        }
    }
}