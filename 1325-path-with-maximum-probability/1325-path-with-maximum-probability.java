class Solution {
    /*
        Algorithm & DS: Dijkstra & BFS
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

        // 무한대로 초기화
        Arrays.fill(dijkstra, INF);
        dijkstra[start_node] = 0;
        pq.offer(Map.entry(start_node, dijkstra[start_node]));

        while(!pq.isEmpty()){
            Map.Entry<Integer, Double> node = pq.poll();
            int curr = node.getKey();
            //double currWeight = node.getValue();

            if(visitied[node.getKey()]){
                continue;
            }
            visitied[node.getKey()] = true;

            for(int i = 0; i < adjs.get(curr).size(); i++){
                Map.Entry<Integer, Double> adj = adjs.get(curr).get(i);
                int next = adj.getKey();
                double nextWeight = adj.getValue();

                double cost = dijkstra[curr] <= 0 ? 1 * nextWeight : dijkstra[curr] * nextWeight;

                if(dijkstra[next] != 0 && cost > dijkstra[next]){
                    dijkstra[next] = cost;
                    pq.offer(Map.entry(next, cost));
                }
            }
        }

        return Math.max(dijkstra[end_node], 0);
    }
}