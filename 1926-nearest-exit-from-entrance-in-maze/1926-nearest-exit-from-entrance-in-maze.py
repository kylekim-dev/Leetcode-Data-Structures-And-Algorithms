class Solution:
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        rows = len(maze)
        cols = len(maze[0])
        visitied = [[False] * cols for r in range(rows)]
        queue = []
        
        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]
        
        queue.append([entrance[0], entrance[1], 0])
        
        while queue:
            position = queue.pop(0)
            x, y, dist = position[0], position[1], position[2]

            if x < 0 or y < 0 or x >= rows or y >= cols or visitied[x][y] == True or maze[x][y] == "+":
                continue
                
            if (x == 0 or y == 0 or x == rows - 1 or y == cols - 1) and dist > 0:
                return dist
            
            visitied[x][y] = True
            
            for i in range(len(dx)):
                queue.append([x + dx[i], y + dy[i], dist + 1])

        return -1
            
        
        