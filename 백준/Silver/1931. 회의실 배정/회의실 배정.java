import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    /*
        아이디어
            - 강의실의 끝나는 시간을 기준으로 오름차순으로 정렬한다(우선순위 큐에 넣는다)
                - (1, 5) (5, 6) (7, 8) (5, 8)
            - 큐에 데이터가 없을때까지 아래를 반복한다
                - 다음 회의실 시간을 poll를 한다
                - 만약 다음 회의실 시간을 nextS, 현재 기존 회의실시간을 e라고 할때 s >= e, max++;을 해주고 e = nextE;를 실행한다.
     */

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] time = new int[N][2];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                time[i][0] = s;
                time[i][1] = e;
            }

            Arrays.sort(time, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {

                    if(o1[1] == o2[1]){
                        return Integer.compare(o1[0], o2[0]);
                    }

                    return Integer.compare(o1[1], o2[1]);
                }
            });

            int meetCount = 0;
            int prevEnd = 0;

            for(int i = 0; i < N; i++){
                if(prevEnd <= time[i][0]){
                    prevEnd = time[i][1];
                    meetCount++;
                }
            }

            System.out.print(meetCount);
        }
        catch (IOException ex) {

        }
    }
}