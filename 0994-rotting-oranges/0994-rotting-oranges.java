class Solution {
    public int orangesRotting(int[][] grid) {
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { -1, 0, 1, 0 };
        int minutes = 0;
        int n = grid.length;
        int m = grid[0].length;

        Queue<Integer> qx = new ArrayDeque<>();
        Queue<Integer> qy = new ArrayDeque<>();

        for(int y = 0; y < n; y++){
            for(int x = 0; x < m; x++){
                if(grid[y][x] == 2){
                    qx.add(x);
                    qy.add(y);
                }
            }
        }

        while (!qx.isEmpty()){
            int rottenCount = qx.size();

            for(int i = 0; i < rottenCount; i++){
                int currX = qx.poll();
                int currY = qy.poll();

                for(int d = 0; d < dx.length; d++){
                    int nextX = currX + dx[d];
                    int nextY = currY + dy[d];

                    if(nextX < 0 || nextY < 0 || nextX >= m || nextY >= n || grid[nextY][nextX] != 1){
                        continue;
                    }
                    grid[nextY][nextX] = 2;
                    qx.add(nextX);
                    qy.add(nextY);
                }
            }

            if(!qx.isEmpty()){
                minutes += 1;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return minutes;
    }
}