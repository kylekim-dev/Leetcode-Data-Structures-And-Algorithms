class Solution {
    public int minPathSum(int[][] grid) {
        // Time: O(N)
        // DP, Memoigetion
        int n = grid.length;
        int m = grid[0].length;

        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(r == 0 && c == 0) continue;
                int a = r - 1 >= 0 ? grid[r-1][c] : Integer.MAX_VALUE;
                int b = c - 1 >= 0 ? grid[r][c-1] : Integer.MAX_VALUE;
                grid[r][c] += Math.min(a,b);
            }
        }

        return grid[n-1][m-1];
    }
}