class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        /*
            Algorithms & DS: #BFS, #Queue
            Time: O(N*M), Extra Space: O(N*M)
         */

        int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
        int m = maze.length, n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        int depth = 0;

        q.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        

        while (!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] curr = q.poll();

                for(int j = 0; j < dr.length; j++){
                    int[] next = { curr[0] - dr[j], curr[1] - dc[j] };

                    if(next[0] < 0 || next[1] < 0 || next[0] >= m || next[1] >= n){
                        if(depth > 0){
                            return depth;
                        }
                    }
                    else if(maze[next[0]][next[1]] == '.'){
                        q.offer(next);
                        maze[next[0]][next[1]] = '+';
                    }
                }
            }

            depth++;
        }
        
        return -1;
    }
}