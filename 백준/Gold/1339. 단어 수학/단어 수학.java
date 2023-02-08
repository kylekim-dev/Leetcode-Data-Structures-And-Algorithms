import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
        아이디어
            - 백트래킹을 사용한다
            - HashMap을 만들고 알파뱃에 숫자를 넣어준다.
            - 백트래킹의 재귀의 깊이가 hashmap 사이즈와 같으면 스트링을 숫자로 변환하고 최대 값을 갱신해준다.

        시간복잡도
            O(N!) N = 8 < 2*10^8
        자료구조
            백트리킹
            해쉬맵
            수의 최대 길이는 10^8 이므로 int
     */

    public static int max = Integer.MIN_VALUE;
    public static boolean[] visit = new boolean[10];
    public static HashMap<Character, Integer> map = new HashMap<>();
    public static int getValue(String str){
        int val = 0;

        for(int i = 0; i < str.length(); i++){
            val *= 10;
            val += map.get(str.charAt(i));
        }

        return val;
    }

    public static void backtracking(int depth, String[] strs){
        if(depth >= map.size()){
            int sum = 0;

            for(String str : strs){
                sum += getValue(str);
            }

            max = Math.max(sum, max);
            return;
        }

        for(int i = 0; i < map.size(); i++){
            if(visit[i]){
                continue;
            }
            visit[i] = true;
            Character c = null;
            for (Character key : map.keySet()) {
                if(map.get(key) == -1){
                    c = key;
                    break;
                }
            }

            map.put(c, 9 - i);
            backtracking(depth + 1, strs);
            map.put(c, -1);
            visit[i] = false;
        }
    }

    public static void solution(int N, String[] strs) {
        for(String str : strs){
            for(int i = 0; i < str.length(); i++){
                map.put(str.charAt(i), -1);
            }
        }

        backtracking(0, strs);
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            String[] strs = new String[N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                strs[i] = st.nextToken();
            }

            solution(N, strs);

            System.out.print(max);
        }
        catch (IOException ex){

        }
    }
}