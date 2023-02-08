import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
        아이디어
            1. 왼쪽에 있는 계란을 든다.
            2. 왼쪽 계란이 깨졌다면 다음 계란을 든다.
            3. 왼쪽 계란이 깨지지 않았다면 부딪칠 수 있는 계란들을 부딪치고, 다음 계란을 든다.
            4. 3의 과정에서 한 번도 계란을 부딪치지 않았다면 모든 계란이 깨져있다는 것이므로 dfs 알고리즘을 빠져나온다.
            5. 1의 과정을 반복한다.

        시간복잡도
            O(N!) N = 8 < 2*10^8
        자료구조
            백트리킹
            해쉬맵
            수의 최대 길이는 10^8 이므로 int
     */

    public static int N;
    public static int[] sList;
    public static int[] wList;
    public static int max;
    public static void solution(int depth) {
        if(depth >= N){
            int c = 0;
            for(int i = 0; i < sList.length; i++){
                if (sList[i] <= 0) {
                    c++;
                }
            }
            max = Math.max(max, c);
            return;
        }

        boolean used = false;

        for(int i = 0; i < sList.length; i++){
            if(i == depth || sList[i] <= 0 || sList[depth] <= 0){
                continue;
            }
            sList[i] -= wList[depth];
            sList[depth] -= wList[i];
            used = true;
            solution(depth + 1);
            sList[i] += wList[depth];
            sList[depth] += wList[i];
        }

        if(!used){
            solution(depth + 1);
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            sList = new int[N];
            wList = new int[N];
            max = Integer.MIN_VALUE;

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                sList[i] = Integer.parseInt(st.nextToken());
                wList[i] = Integer.parseInt(st.nextToken());
            }

            solution(0);

            System.out.print(max);
        }
        catch (IOException ex){

        }
    }
}