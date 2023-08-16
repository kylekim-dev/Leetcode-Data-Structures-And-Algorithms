class Solution {
    /*
        Algorithm & DS: Dijkstra & BFS & Max Heap
        Time: O(E * Log V), Space: O(V)
    */
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Key: Node #, Value: Edge Weight
        // Value(가충치)를 기준으로 Decresending
        PriorityQueue<Map.Entry<Integer, Double>> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()));
        List<List<Map.Entry<Integer, Double>>> adjs = new ArrayList<>();
        double[] dijkstra = new double[n];
        boolean[] visitied = new boolean[n];
        double INF = -1;

        // 인접노드 정보 저장
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0], b = edges[i][1];
            double weight = succProb[i];

            while(adjs.size() <= Math.max(a, b))
                adjs.add(new ArrayList<>());

            // a -> b
            List<Map.Entry<Integer, Double>> adj = adjs.get(a);
            adj.add(Map.entry(b, weight));

            // b -> a
            adj = adjs.get(b);
            adj.add(Map.entry(a, weight));
        }

        
        Arrays.fill(dijkstra, INF); // 다익스트라 배열 초기화
        dijkstra[start_node] = 0;   // 시작노드 가중치 0으로 초기화
        pq.offer(Map.entry(start_node, dijkstra[start_node])); // 우선순위 큐에 시작노드 입력

        while(!pq.isEmpty()){
            Map.Entry<Integer, Double> node = pq.poll();
            int curr = node.getKey();

            // 방문한 노드였으면 스킵
            if(visitied[node.getKey()]) continue;
            visitied[node.getKey()] = true;

            for(int i = 0; i < adjs.get(curr).size(); i++){
                Map.Entry<Integer, Double> adj = adjs.get(curr).get(i);
                int next = adj.getKey();
                double nextWeight = adj.getValue();

                // 선이 연결 안된상태, 즉 가중치가 0 이하 인경우에 현재 다익스트라 가중치를 1로 초기화
                // 두 수를 곱하기 때문에 -1 or 0을 곱하면 0 이하의 값으로 초기화되는 문제 방지
                double cost = dijkstra[curr] <= 0 ? 1 * nextWeight : dijkstra[curr] * nextWeight;

                // 해당 경로가 기존 경로보다 더 높은 가중치를 가지면 다익스트라 테이블을 갱신해주고
                // 우선순위 큐에 해당 경로를 저장함.
                if(dijkstra[next] != 0 && cost > dijkstra[next]){
                    dijkstra[next] = cost;
                    pq.offer(Map.entry(next, cost));
                }
            }
        }

        return Math.max(dijkstra[end_node], 0);
    }
}