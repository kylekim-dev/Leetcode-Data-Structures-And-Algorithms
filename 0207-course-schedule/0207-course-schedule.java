class Solution {
    /*
        Algorithm & DS: Topological Sort - Kahn's Algorithm
        Time: O(V + E), Space: O(V + E)
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] pre : prerequisites){
            int from = pre[1];
            int to = pre[0];
            
            adj.get(from).add(to);
            indegree[to]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int to = 0; to < numCourses; to++){
            if(indegree[to] == 0) queue.offer(to);
        }
        
        int takenCount = 0;
        
        while(!queue.isEmpty()){
            int from = queue.poll();
            takenCount++;
            
            if(takenCount >= numCourses) return true;
            
            for(int neighbor : adj.get(from)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        
        return takenCount >= numCourses;
    }
}