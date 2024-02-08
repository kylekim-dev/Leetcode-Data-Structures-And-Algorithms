class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        maxArea = 0
        def recursive(grid, r, l, area) -> int:
            if r < 0 or l < 0 or r >= len(grid) or l >= len(grid[r]) or grid[r][l] == 0:
                return area
            
            grid[r][l] = 0
            
            return 1 + recursive(grid, r - 1, l, area) + recursive(grid, r + 1, l, area) + recursive(grid, r, l - 1, area) + recursive(grid, r, l + 1, area)
            
        
        for r in range(len(grid)):
            for l in range(len(grid[r])):
                if grid[r][l] == 1:
                    maxArea = max(maxArea, recursive(grid, r, l, 0))
        
        return maxArea
                
                
        
        