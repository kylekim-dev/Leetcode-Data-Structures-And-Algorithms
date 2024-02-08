class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        /*
            Algorithms & DS: #DFS, #Stack
            Time: O(N*M), Extra Space: O(N * M)
        */
        int m = grid.length, n = grid[0].length;
        int maxArea = 0;
        int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
        int div = 100;
        
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 1){
                    Queue<Integer> q = new LinkedList<>();
                    int area = 0;

                    q.offer(r * div + c);

                    while(!q.isEmpty()){
                        int coordinate = q.poll();
                        int currRow = coordinate / div, currCol = coordinate % div;
                        if(grid[currRow][currCol] == 0){
                            continue;
                        }
                        grid[currRow][currCol] = 0;
                        area++;

                        for(int i = 0; i < dr.length; i++){
                            int nextRow = currRow + dr[i], nextCol = currCol + dc[i];

                            if(nextRow < 0 || nextCol < 0 || nextRow >= m || nextCol >= n || grid[nextRow][nextCol] == 0){
                                continue;
                            }

                            q.offer(nextRow * div + nextCol);
                        }
                    }

                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        return maxArea;
    }
}