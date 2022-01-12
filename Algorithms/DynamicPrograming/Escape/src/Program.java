import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Program {
    public static void main(String[] args){
        /*
        문제
        사악한 암흑의 군주 이민혁은 드디어 마법 구슬을 손에 넣었고, 그 능력을 실험해보기 위해 근처의 티떱숲에 홍수를 일으키려고 한다.
        이 숲에는 고슴도치가 한 마리 살고 있다. 고슴도치는 제일 친한 친구인 비버의 굴로 가능한 빨리 도망가 홍수를 피하려고 한다.
        티떱숲의 지도는 R행 C열로 이루어져 있다. 비어있는 곳은 '.'로 표시되어 있고, 물이 차있는 지역은 '*', 돌은 'X'로 표시되어 있다.
        비버의 굴은 'D'로, 고슴도치의 위치는 'S'로 나타내어져 있다.
        매 분마다 고슴도치는 현재 있는 칸과 인접한 네 칸 중 하나로 이동할 수 있다.
        (위, 아래, 오른쪽, 왼쪽) 물도 매 분마다 비어있는 칸으로 확장한다. 물이 있는 칸과 인접해있는 비어있는 칸(적어도 한 변을 공유)은 물이 차게 된다.
        물과 고슴도치는 돌을 통과할 수 없다. 또, 고슴도치는 물로 차있는 구역으로 이동할 수 없고, 물도 비버의 소굴로 이동할 수 없다.
        티떱숲의 지도가 주어졌을 때, 고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소 시간을 구하는 프로그램을 작성하시오.
        고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다. 즉, 다음 시간에 물이 찰 예정인 칸으로 고슴도치는 이동할 수 없다.
        이동할 수 있으면 고슴도치가 물에 빠지기 때문이다.

        R: row, C: col,
        .: empty, *: water, X: rock
        D: 목표, S: 고슴도치 위치
         */
        String[][] cavMap = new String[][]{
                {"D", ".", "*"},
                {".", ".", "."},
                {".", "S", "."}};

        /*cavMap = new String[][]{
                {"D", ".", ".", ".", "*", "."},
                {".", "X", ".", "X", ".", "."},
                {".", ".", ".", ".", "S", "."}};

        cavMap = new String[][]{
                {".", "D", ".", "*"},
                {".", ".", ".", "."},
                {".", ".", "X", "."},
                {"S", ".", "*", "."},
                {".", ".", ".", "."}};*/

        var res = findGoal(cavMap);

        System.out.println(res);
    }

    public static String findGoal(String[][] cavMap){
        int ans = 0;
        int r = cavMap.length;
        int c = cavMap[0].length;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Node> waterQ = new LinkedList<>();
        Queue<Node> hedgehogQ = new LinkedList<>();

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(cavMap[i][j] == "S"){
                    hedgehogQ.add(new Node(i, j));
                }
                else if(cavMap[i][j] == "*"){
                    waterQ.add(new Node(i, j));
                }
            }
        }

        while (!waterQ.isEmpty() && !hedgehogQ.isEmpty()){
            int waterSize = waterQ.size();
            for (int s = 0; s < waterSize; s++)
            {
                Node waterNode = waterQ.remove();

                for(int i = 0; i < dx.length; i++){
                    int nextX = dx[i] + waterNode.x;
                    int nextY = dy[i] + waterNode.y;

                    if(nextX < r && nextX > -1 && nextY < c && nextY > -1){
                        if(cavMap[nextX][nextY] == "."){
                            cavMap[nextX][nextY] = "*";
                            waterQ.add(new Node(nextX, nextY));
                        }
                    }
                }
            }

            int hedgehogSize = hedgehogQ.size();
            for (int s = 0; s < hedgehogSize; s++){
                Node hedgehogNode = hedgehogQ.remove();

                for(int i = 0; i < dx.length; i++){
                    int nextX = dx[i] + hedgehogNode.x;
                    int nextY = dy[i] + hedgehogNode.y;

                    if(nextX < r && nextX > -1 && nextY < c && nextY > -1){
                        if(cavMap[nextX][nextY] == "."){
                            hedgehogQ.add(new Node(nextX, nextY));
                        }
                        else if(cavMap[nextX][nextY] == "D"){
                            return String.valueOf(ans + 1);
                        }
                    }
                }
            }
            ans++;
        }

        return "KAKTUS";
    }

    public static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
