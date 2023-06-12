class Solution {
    void dfs(char[][] grid, int x, int y){
        if (x < 0 || y < 0 || y >= grid.length || x >= grid[y].length || grid[y][x] == '0')
            return;
        
        grid[y][x] = '0';
        
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
    }
    
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int y = 0; y < grid.length; y++){
            for(int x = 0; x < grid[y].length; x++){
                if(grid[y][x] == '1'){
                    dfs(grid, x, y);
                    count += 1;
                }
            }
        }
        
        return count;
    }
}