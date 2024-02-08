class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        /*
            Algorithms & DS: #DFS, #Stack
            Time: O(N*M), Extra Space: O(N * M)
        */
        int m = grid.length, n = grid[0].length;
        int maxArea = 0;
        int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
        
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 1){
                    Stack<Integer> stack = new Stack<>();
                    int area = 0;
                    
                    stack.push(r * 100 + c);
                    
                    while(!stack.isEmpty()){
                        int coordinate = stack.pop();
                        int currCol = coordinate % 100, currRow = coordinate / 100;
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

                            stack.push(nextRow * 100 + nextCol);
                        }
                    }

                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        return maxArea;
    }
}