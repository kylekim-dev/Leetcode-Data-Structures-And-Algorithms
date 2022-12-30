import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
        아이디어
            - 그림의 정보를 nxm 배열에 저장
            - 배열 탐색 중 1을 만나면 BFS 재귀 탐색 시작
            - 방문한 그림을 2로 변경하여 그림 정보를 지움
        시간복잡도
            - O(N*M) = 1*10^6 <= 1,000,000
        자료구조
            - count: 그림의 갯수
            - maxSize: 가장 큰 그림의 크기
     */
    static int count = 0;
    static int maxSize = 0;
    final static int[] X = new int[]{ 0, 1, 0, -1 };
    final static int[] Y = new int[]{ -1, 0, 1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] picture = new int[n][m];
        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();

        for (int r = 0; r < n; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++){
                picture[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < n; r++){
            for (int c = 0; c < m; c++){
                if (picture[r][c] == 1){
                    int tempSize = 1;
                    picture[r][c] = 0;
                    qr.add(r);
                    qc.add(c);

                    while(qr.isEmpty() == false){
                        int row = qr.poll();
                        int col = qc.poll();

                        for (int i = 0; i < X.length; i++){
                            int nextRow = row + X[i];
                            int nextCol = col + Y[i];

                            if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m || picture[nextRow][nextCol] == 0){
                                continue;
                            }
                            picture[nextRow][nextCol] = 0;
                            qr.add(nextRow);
                            qc.add(nextCol);
                            tempSize++;
                        }
                    }

                    maxSize = Math.max(tempSize, maxSize);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }
}