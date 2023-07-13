class Solution {
    /*
    
        Algorithm & DS: Topology Sort, Queue
        Time: O(V + E), Space: O(V + E)
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] pre : prerequisites){
            int to = pre[0], from = pre[1];
            adj.get(from).add(to);
            indegrees[to]++;
        }
        
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int node = 0; node < indegrees.length; node++){
            if(indegrees[node] == 0) queue.offer(node);
        }
        
        int[] output = new int[numCourses];
        int idx = 0;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            
            output[idx] = node;
            idx++;
            
            for(int neighbor : adj.get(node)){
                indegrees[neighbor]--;
                
                if(indegrees[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        
        return idx == numCourses ? output : new int[0];
    }
}