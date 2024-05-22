class Solution {
    final int[] DR = {0, 1, 0, -1};
    final int[] DC = {1, 0, -1, 0};
    
    public int numIslands(char[][] grid) {
        int islands = 0;
        
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c++){
                if(grid[r][c] == '1'){                    
                    islands += 1;
                    grid[r][c] = '0';
                    dfs(grid, r, c);
                }
            }
        }
        
        return islands;
    }
    
    public void dfs(char[][] grid, int r, int c){
        for(int i = 0; i < DR.length; i++){
            int nextR = r + DR[i];
            int nextC = c + DC[i];
            
            if(nextR < 0 || nextR >= grid.length || nextC < 0 || nextC >= grid[nextR].length || grid[nextR][nextC] == '0'){
                continue;
            }
            grid[nextR][nextC] = '0';
            dfs(grid, nextR, nextC);
        }
    }
}