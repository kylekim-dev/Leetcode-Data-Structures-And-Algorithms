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
            HashSet<String> set = new HashSet<>();
            String str = st.nextToken();

            for(int s = 0; s < str.length(); s++){
                for(int e = s + 1; e <= str.length(); e++){
                    set.add(str.substring(s, e));
                }
            }

            System.out.print(set.size());
        }
        catch (IOException ex){

        }
    }
}