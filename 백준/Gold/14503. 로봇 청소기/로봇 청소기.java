import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    /*
        아이디어
            - 배열 area를 사용하여
            - 재귀함수의 종료 조건은 인접 노드의 값이 모두 = 0이거나, 배열 인덱스를 벗어났을 때
            - 방문한 배열의 값을 0으로 전환
        시간복잡도
            - O(N*N) = 50 * 50 < 2 * 10^8
        자료구조
            - 결과: static int
            - Area: int[n][m]
            - Command: int[]
     */

    private static int[] dCol = new int[]{ 0, 1, 0, -1 };
    private static int[] dRow = new int[]{ -1, 0, 1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int DIRTY = 0;
        final int WALL = 1;
        final int CLEAN = 2;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] area = new int[n][m];
        int row, nextRow;
        int col, nextCol;
        int direction;
        int cleanedAreaCount = 0;
        boolean backStatus = false;
        boolean finish = false;

        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        nextRow = row;
        nextCol = col;
        direction = Integer.parseInt(st.nextToken());

        for (int r = 0; r < n; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < m; c++){
                area[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        while (!finish){
            if (area[row][col] == DIRTY){
                area[row][col] = CLEAN;
                cleanedAreaCount++;
            }
            boolean pass = false;
            while (!pass) {
                for(int i = 0; i < dCol.length; i++){
                    direction = (dCol.length + direction - 1) % dCol.length;
                    nextRow = row + dRow[direction];
                    nextCol = col + dCol[direction];

                    if(area[nextRow][nextCol] == DIRTY){
                        row = nextRow;
                        col = nextCol;
                        pass = true;
                        break;
                    }
                }

                if(!pass){
                    row -= dRow[direction];
                    col -= dCol[direction];
                    if(area[row][col] == WALL){
                        pass = true;
                        finish = true;
                    }
                }
            }
        }

        System.out.print(cleanedAreaCount);
    }
}