import java.io.*;
import java.util.*;

public class Main {
    /*
        아이디어

        시간복잡도

        자료구조
     */


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String gameType = st.nextToken();
        HashSet<String> players = new HashSet<>();

        for(int i = 0; i < N; i++){
            players.add(br.readLine());
        }

        System.out.print(playTimeCount(players, gameType));
    }

    public static int playTimeCount(HashSet<String> players, String gameType){
        if(gameType.equals("Y")){
            return players.size();
        }
        if(gameType.equals("F")){
            return players.size() / 2;
        }
        if(gameType.equals("O")){
            return players.size() / 3;
        }

        return 0;
    }
}