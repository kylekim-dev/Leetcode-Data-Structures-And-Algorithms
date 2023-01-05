import java.io.*;
import java.util.*;

public class Main {
    /*
        아이디어
            - A와 B의 변화 추이의 합이 2000 이상이면 A와 B는 사이가 나쁘다
            - N - 1 / 2 < badCounter, badCounter = 변화 추이 합이 2000이상인 사람
        시간복잡도
            - O(N*M) 10,000 * 100 < 1 * 10^8
        자료구조

     */
    static int V, E;
    static ArrayList<ArrayList<Node>> graph;

    static class Node {// 다음 노드의 인덱스와, 그 노드로 가는데 필요한 비용을 담고 있다.
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static int[] dijkstra(int start){
        // 다익스트라 알고리즘 초기화
        int[] dist = new int[V + 1]; // 최소 비용을 저장할 배열
        for (int i = 0; i < V + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 주의점 1. 다익스트라 알고리즘의 최소비용을 기준으로 추출해야 한다. 최대 비용을 기준으로 하는 경우 최악의 경우 지수시간 만큼의 연산을
        // 해야한다!
        PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        // 시작 노드에서, 시작 노드로 가는 값이 초기에 가장 짧은 비용을 갖는 노드이다.
        // 즉, 도착 정점은 start, 비용은 0인 노드를 가장 먼저 선택할 것이다.
        q.offer(new Node(start, 0));
        // 해당 노드를 선택한 것이나 마찬가지 이므로, dist[start] = 0으로 갱신.
        dist[start] = 0;
        while (!q.isEmpty()) {
            Node curNode = q.poll();

            // 목표 정점이 꺼내 졌다면, 해당 노드까지는 최솟값 갱신이 완료 되었다는 것이 확정이다(다익스트라 알고리즘).
            // 따라서, 반복문을 종료해도 되지만, 해당 코드는 시작 정점에 대하여 모든 정점으로의 최단 경로를 구하는 것을 가정한다.
            // 아래 주석된 코드는 목표 정점이 구해졌다면 빠르게 탈출할 수 있는 조건이다.
//			if (curNode.idx == end) {
//				System.out.println(dist[curNode.idx]);
//				return;
//			}

            // 꺼낸 노드 = 현재 최소 비용을 갖는 노드.
            // 즉, 해당 노드의 비용이 현재 dist배열에 기록된 내용보다 크다면 고려할 필요가 없으므로 스킵한다.
            // 주의점 2 : 중복노드 방지1 : 만일, 이 코드를 생략한다면, 언급한 내용대로 이미 방문한 정점을 '중복하여 방문'하게 된다.
            // 만일 그렇다면, 큐에 있는 모든 다음 노드에대하여 인접노드에 대한 탐색을 다시 진행하게 된다.
            // 그래프 입력이 만일 완전 그래프의 형태로 주어진다면, 이 조건을 생략한 것 만으로 시간 복잡도가 E^2에 수렴할 가능성이 생긴다.
            if (dist[curNode.idx] < curNode.cost) {
                continue;
            }

            // 선택된 노드의 모든 주변 노드를 고려한다.
            for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
                Node nxtNode = graph.get(curNode.idx).get(i);
                // 만일, 주변 노드까지의 현재 dist값(비용)과 현재 선택된 노드로부터 주변 노드로 가는 비용을 비교하고, 더 작은 값을 선택한다.
                // 주의점 3 : 중복노드 방지 2 : 만일, 조건문 없이 조건문의 내용을 수행한다면 역시 중복 노드가 발생한다.
                // 간선에 연결된 노드를 모두 넣어준다면 앞서 언급한 정점의 시간 복잡도 VlogV를 보장할 수 없다.
                // 마찬가지로 E^2에 수렴할 가능성이 생긴다. 따라서 이 조건 안에서 로직을 진행해야만 한다.
                if (dist[nxtNode.idx] > curNode.cost + nxtNode.cost) {
                    dist[nxtNode.idx] = curNode.cost + nxtNode.cost;
                    // 갱신된 경우에만 큐에 넣는다.
                    q.offer(new Node(nxtNode.idx, dist[nxtNode.idx]));
                }
            }
        }

        // 결과 출력
        return dist;
        //System.out.println(Arrays.toString(dist));
    }

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<Node>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 문제에서는 유향 그래프에서의 다익스트라 알고리즘(이 조건도 문제에 따라 중요하다!).
            graph.get(s).add(new Node(e, c));
        }

        ArrayList<int[]> shorestPath = new ArrayList<>();
        shorestPath.add(new int[]{});
        for(int i = 1; i < V + 1; i++){
            shorestPath.add(dijkstra(i));
        }
        int output = 0;
        for(int i = 1; i < V + 1; i++){
            output = Math.max(output, shorestPath.get(i)[X] + shorestPath.get(X)[i]);
        }

        System.out.println(output);
    }
}