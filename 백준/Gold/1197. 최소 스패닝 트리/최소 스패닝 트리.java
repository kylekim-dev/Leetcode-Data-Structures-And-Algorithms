/*
    1. 아이디어
        - 최소 신장트리를 사용
        - 우선순위 큐를 사용해 해결
        - 1번 노드에 가중치 0으로 시작 (우선순위 큐에 담음)
        - 1. 큐에서 노드를 꺼냄
        - 2. 꺼낸 노드의 방문 여부를 체크, 방문했으면 1번으로 돌아감
        - 3. 방문하지 않았으면 방문자 체크, 해당 노드의 가중치를 총 가중치에 더함
        - 4. 현재 노드에 인접 노드들을 탐색하면서 큐에 넣어줌
        - 5. 큐가 비어있지 않으면 1번 반복

    2. 시간 복잡도
        - O(N), 30,000 < 1 *10^8
    3. 자료구조
        - 먹은 스시: HashMap<Integer>
        - 결과: Integer
 */

import java.io.*;
import java.util.*;

public class Main {

    public static class Node {
        int vertex, weight;
        public Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        boolean[] visited = new boolean[V+1];

        for(int i = 0; i < V + 1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        int min = 0;

        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()){
            Node currNode = pq.poll();

            if(visited[currNode.vertex]){
                continue;
            }

            visited[currNode.vertex] = true;
            min += currNode.weight;

            for(int i = 0; i < graph.get(currNode.vertex).size(); i++){
                Node nextNode = graph.get(currNode.vertex).get(i);
                /*if(visited[nextNode.vertex] == true){
                    continue;
                }*/
                pq.offer(nextNode);
            }
        }

        System.out.print(min);
    }
}